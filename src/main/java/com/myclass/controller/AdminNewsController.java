package com.myclass.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.myclass.constant.PathConstant;
import com.myclass.constant.UserConstant;
import com.myclass.entity.Category;
import com.myclass.entity.Comment;
import com.myclass.entity.Post;
import com.myclass.service.CategoryService;
import com.myclass.service.CommentService;
import com.myclass.service.PostService;

@Controller
@RequestMapping("/admin/news")
public class AdminNewsController {
	@Autowired
	CategoryService categoryService;

	@Autowired
	PostService postService;

	@Autowired
	CommentService commentService;

	// news management page
	@GetMapping(path = "")
	String news(Model model) {
		model.addAttribute("posts", postService.findAllByAdmin());

		return "admin-page/v1/news/index";
	}

	// show add news page
	@GetMapping(path = "/add")
	String addNews(Model model) {

		model.addAttribute("plantCategories", categoryService.findByCategoryTypeId(1));
		model.addAttribute("contentCategories", categoryService.findByCategoryTypeId(2));
		model.addAttribute("post", new Post());
		return "admin-page/v1/news/add";
	}

	// add news
	@PostMapping(path = "/add", consumes = { "multipart/form-data" })
	String postAddNews(@ModelAttribute Post post, Model model, HttpServletRequest request,
			@RequestPart("imageUpload") MultipartFile file) throws IOException {
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute(UserConstant.USER_ID);
		this.postService.save(post, userId, request, categoryService, file);
		return "redirect:";
	}

	// show edit news page
	@GetMapping(path = "/edit/{id}")
	String editNews(Model model, @PathVariable(value = "id") String id) {
		model.addAttribute("plantCategories", categoryService.findByCategoryTypeId(1));
		model.addAttribute("contentCategories", categoryService.findByCategoryTypeId(2));
		model.addAttribute("post", this.postService.findById(id));
		return "admin-page/v1/news/edit";
	}

	// soft delete
	@GetMapping(path = "/soft-delete")
	String softDelete(@RequestParam String id) {
		this.postService.softDelete(id);
		return "redirect:/admin/news";
	}
	
	// delete
	@GetMapping(path = "/delete")
	String delete(@RequestParam String id) {
		this.postService.deleteById(id);
		return "redirect:/admin/news";
	}

	// restore news
	@GetMapping(path = "/restore")
	String restore(@RequestParam String id) {
		this.postService.restore(id);
		return "redirect:/admin/news/deleted";
	}

	// show deleted news page
	@GetMapping(path = "/deleted")
	String restoreNewsPage(Model model) {
		model.addAttribute("posts", postService.findAllNewsDeleted());
		return "admin-page/v1/news/deleted";
	}

	// show detail news page
	@GetMapping(path = "/detail")
	String detail(@RequestParam String id, Model model) { 
		Post post = this.postService.findById(id);
		 
		model.addAttribute("post", post);
		model.addAttribute("comments", post.getComments());
		return "admin-page/v1/news/detail";
	}

	// show edit news page
	@GetMapping(path = "/edit")
	String edit(@RequestParam String id, Model model) {
		Post post = this.postService.findById(id); 
		
		// get current categories of current post 
		List<Integer> currentCategoryIds = new ArrayList<Integer>();
		List<Category> categories = post.getCategories();
		for (Category category : categories) {
			currentCategoryIds.add(category.getId());
		} 
		model.addAttribute("currentCategoryIds", currentCategoryIds);
		
		// get all categories by types
		model.addAttribute("plantCategories", categoryService.findByCategoryTypeId(1));
		model.addAttribute("contentCategories", categoryService.findByCategoryTypeId(2)); 
		 
		// get current post
		model.addAttribute("post", post);
		return "admin-page/v1/news/edit";
	}
	
	// handle edit news request
	@PostMapping(path = "/edit", consumes = { "multipart/form-data" })
	String edit(@ModelAttribute Post post, Model model, HttpServletRequest request) throws IOException { 
		
		this.postService.update(post, request, categoryService);
		 
		return "redirect:";
	}
}
