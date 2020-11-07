package com.myclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontPageController {
	@GetMapping(path="/")
	String users(Model model) {
		//model.addAttribute("user", userService.findById(1));
		return "main-web/v1/garden-index.html";
	}
}
