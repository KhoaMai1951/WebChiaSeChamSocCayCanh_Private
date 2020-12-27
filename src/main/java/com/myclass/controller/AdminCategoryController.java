package com.myclass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myclass.service.CategoryService;

@Controller
@RequestMapping("/admin/category")
public class AdminCategoryController {

	@Autowired
	CategoryService categoryService;
	
	@GetMapping(path = "/list")
	String categoryList(Model model) {
		model.addAttribute("categories", categoryService.findAll());

		return "admin-page/v1/categories/index";
	}
}
