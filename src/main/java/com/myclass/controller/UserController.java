package com.myclass.controller;


import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myclass.constant.UserConstant;
import com.myclass.entity.Comment;
import com.myclass.entity.Post;
import com.myclass.entity.User;
import com.myclass.repository.CommentRepository;
import com.myclass.service.CategoryService;
import com.myclass.service.CommentService;
import com.myclass.service.PostService;
import com.myclass.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	CategoryService categoryService;

	@Autowired
	PostService postService;
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	CommentRepository commentRepo;
	
	@GetMapping(path = "/user/detail")
	String userDetail(Model model, @RequestParam(defaultValue = "id") String id) {
		User user = this.userService.findById(Integer.parseInt(id));
		
		model.addAttribute("posts", postService.findAllByUserId(Integer.parseInt(id))); 
		model.addAttribute("postsByComment", postService.findAllByUserComment(Integer.parseInt(id))); 
		model.addAttribute("user", user);
		return "main-web/v1/user-detail.html";
	}
	
	
	@GetMapping(path = "/user/post/add")
	String add(Model model) {
		model.addAttribute("post", new Post());
		model.addAttribute("plantCategories", categoryService.findByCategoryTypeId(1));
		model.addAttribute("contentCategories", categoryService.findByCategoryTypeId(2));
		return "main-web/v1/add.html";
	}
	
	@PostMapping(path = "/user-action/submit-comment")
	String submitComment(@ModelAttribute Comment comment, 
			Model model, 
			HttpServletRequest request,
			@RequestParam("postId") String postId) {
		HttpSession session = request.getSession();
		Post post = this.postService.findById(postId);
		if(session.getAttribute(UserConstant.USER_ID) != null)
		{
			User user = this.userService.findById((Integer) session.getAttribute(UserConstant.USER_ID));
			if(user != null)
			{
				comment.setCreatedDate(new Date(System.currentTimeMillis()));
				comment.setPost(post);
				comment.setUser(user);
				commentRepo.save(comment);
			}
		} 
		return "redirect:/post/detail?id="+postId;
	}
	

}
