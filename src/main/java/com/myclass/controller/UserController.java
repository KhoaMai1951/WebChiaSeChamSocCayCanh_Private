package com.myclass.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.myclass.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
//	@GetMapping("/users")
//	List<User>  users() {
//		return userService.findAll();
//	}
	
	

}
