package com.myclass.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.myclass.constant.UserConstant;
import com.myclass.entity.Post;
import com.myclass.entity.User;
import com.myclass.repository.UserRepository;
import com.myclass.service.UserService;

@Controller
public class LoginController {

	@Autowired
	UserService userService;

	//=====================USER====================
	// show login page
	@GetMapping(path = "/user/login")
	String loginPage(Model model) {
		model.addAttribute("user", new User());
		return "main-web/v1/login.html";
	}

	// user logout
	@GetMapping(path = "/user/logout")
	String logout(HttpSession session) {
		session.removeAttribute(UserConstant.USER_ID);
		return "redirect:/";
	}

	@PostMapping(path = "/user/login")
	String login(Model model, @ModelAttribute User user, HttpServletRequest request) {

		// check user credential
		int userId = userService.findUserByEmailAndPassword(user);
		if (userId > 0) {
			HttpSession session = request.getSession();
			session.setAttribute(UserConstant.USER_ID, userId);
		}
		return "redirect:/";
	}
	
	//=======================ADMIN==================
	// show login page
	@GetMapping(path = "/ad-login")
	String adminLoginPage(Model model) {
		model.addAttribute("user", new User());
		return "admin-page/v1/login.html";
	}
	
	@PostMapping("/ad-login")
	String adminLogin(Model model, @ModelAttribute User user, HttpServletRequest request) {
		System.out.println(88888888);
		// check user credential
		int userId = userService.findAdminByEmailAndPassword(user);
		if (userId > 0) { 
			HttpSession session = request.getSession();
			session.setAttribute(UserConstant.ADMIN_ID, userId);
		}
		return "redirect:/admin/news";
	}
	
	// admin logout
	@GetMapping(path = "/admin/logout")
	String adminLogout(HttpSession session) {
		session.removeAttribute(UserConstant.ADMIN_ID);
		return "redirect:/admin/news";
	}
}
