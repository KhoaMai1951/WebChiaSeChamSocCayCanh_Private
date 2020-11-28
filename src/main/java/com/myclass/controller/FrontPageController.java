package com.myclass.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myclass.entity.Comment; 
import com.myclass.service.CategoryService;
import com.myclass.service.PostService;

@Controller
public class FrontPageController {
	@Autowired
	CategoryService categoryService;

	@Autowired
	PostService postService;

	@GetMapping(path = "/")
	String users(Model model) {
		// model.addAttribute("user", userService.findById(1));
		model.addAttribute("posts", postService.findAll());

		return "main-web/v1/garden-index.html";
	}

	@GetMapping(path = "/detail")
	String detail(Model model, @RequestParam(defaultValue = "id") String id) {
		model.addAttribute("post", this.postService.findById(id));
		model.addAttribute("comment", new Comment());
		return "main-web/v1/detail.html";
	}
	
	@PostMapping(path = "/user-action/submit-comment")
	String submitComment(@ModelAttribute Comment comment, Model model, HttpServletRequest request) {
		System.out.println(comment.getContent());
		return "redirect:/";
	}
}
