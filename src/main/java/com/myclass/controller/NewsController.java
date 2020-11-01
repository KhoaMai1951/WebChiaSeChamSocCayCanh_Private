package com.myclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myclass.entity.Post;

@Controller
@RequestMapping("/admin/news")
public class NewsController {
	// news management page
	@GetMapping(path = "/news")
	String news() {
		return "admin-page/v1/news/index";
	}

	// add news page
	@GetMapping(path = "/news/add")
	String addNews(Model model) {
		Post post = new Post();
		model.addAttribute("post", post);
		return "admin-page/v1/news/add";
	}

	// add news
	@PostMapping(path = "/news/add")
	String postAddNews(@ModelAttribute Post post, Model model) {
		model.addAttribute("post", post);
		return "admin-page/v1/index";
	}
}
