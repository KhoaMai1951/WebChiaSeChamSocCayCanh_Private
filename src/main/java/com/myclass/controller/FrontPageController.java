package com.myclass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.myclass.entity.Post;
import com.myclass.service.CategoryService;
import com.myclass.service.PostService;

@Controller
public class FrontPageController {
	@Autowired
	CategoryService categoryService;

	@Autowired
	PostService postService;
	
	@GetMapping(path="/")
	String users(Model model) {
		//model.addAttribute("user", userService.findById(1));
		model.addAttribute("posts", postService.findAll());
		
		return "main-web/v1/garden-index.html";
	}
	
	@GetMapping(path="/detail")
	String detail(Model model, @RequestParam(defaultValue = "id") String id) {
		model.addAttribute("post", this.postService.findById(id));	 
		return "main-web/v1/detail.html";
	}
}
