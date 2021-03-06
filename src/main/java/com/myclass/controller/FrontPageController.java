package com.myclass.controller;

import java.sql.Date;
import java.util.List;

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
public class FrontPageController {
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

	@GetMapping(path = "/")
	String index(Model model) {

		model.addAttribute("posts", postService.findAllPostsWithCategories());

		return "main-web/v1/garden-index.html";
	}

	@GetMapping(path = "/post-by-category")
	String postByCategory(Model model, @RequestParam(defaultValue = "id") String id) {

		model.addAttribute("posts", postService.findAllByCategoryId(Integer.parseInt(id)));

		return "main-web/v1/garden-index.html";
	}

	@GetMapping(path = "/post/detail")
	String postDetail(Model model, @RequestParam(defaultValue = "id") String id) {
		Post post = this.postService.findById(id);
		model.addAttribute("user", userService.findUserByPostId(post));
		model.addAttribute("post", post);
		model.addAttribute("comment", new Comment());
		model.addAttribute("comments", this.commentService.getCommentsNotDeletedByPostId(post.getId()));
		return "main-web/v1/post-detail.html";
	}

	// search posts
	@PostMapping(path = "/post/search")
	String search(Model model, @ModelAttribute User user, HttpServletRequest request) {System.out.println(postService.searchPost("C"));
		
	model.addAttribute("posts", postService.searchPost((String) request.getAttribute("condition")));

		return "main-web/v1/garden-index.html";
	}

}
