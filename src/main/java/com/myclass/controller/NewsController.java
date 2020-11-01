package com.myclass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myclass.entity.Category;
import com.myclass.entity.Post;
import com.myclass.service.CategoryService;

@Controller
@RequestMapping("/admin/news")
public class NewsController {
	@Autowired
	CategoryService categoryService;
	
	// news management page
	@GetMapping(path = "")
	String news() {
		return "admin-page/v1/news/index";
	}

	// add news page
	@GetMapping(path = "/add")
	String addNews(Model model) {
		
		model.addAttribute("plantCategories", categoryService.findByCategoryTypeId(1));
		model.addAttribute("contentCategories", categoryService.findByCategoryTypeId(2));
		model.addAttribute("post", new Post());
		return "admin-page/v1/news/add";
	}

	// add news
	@PostMapping(path = "/add")
	String postAddNews(@ModelAttribute Post post, Model model) {
		model.addAttribute("post", post);
		return "admin-page/v1/index";
	}
}
