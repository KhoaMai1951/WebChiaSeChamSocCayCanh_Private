package com.myclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	// show login page
	@GetMapping(path="/login")
	String login(Model model) {
		return "main-web/v1/login.html";
	}
}
