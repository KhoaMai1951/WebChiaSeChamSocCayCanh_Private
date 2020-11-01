package com.myclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myclass.entity.Post;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	// index page
	@GetMapping(path = "")
	String users() {
		return "admin-page/v1/index";
	}

	
}
