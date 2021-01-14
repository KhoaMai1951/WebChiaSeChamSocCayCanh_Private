package com.myclass.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myclass.entity.Category;
import com.myclass.entity.CategoryType;
import com.myclass.entity.User;
import com.myclass.service.CategoryService;
import com.myclass.service.CategoryTypeService;

@Controller
@RequestMapping("/admin/category")
public class AdminCategoryController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	CategoryTypeService categoryTypeService;

	@GetMapping(path = "/list")
	String categoryList(Model model) {
		model.addAttribute("categories", categoryService.findAll());

		return "admin-page/v1/categories/index";
	}

	// soft delete
	@GetMapping(path = "/soft-delete")
	String softDelete(@RequestParam String id) {
		this.categoryService.softDelete(Integer.parseInt(id));
		return "redirect:/admin/category/list";
	}

	// soft delete page
	@GetMapping(path = "/deleted")
	String deletedPage(Model model) {
		model.addAttribute("categories", categoryService.findAllDeleted());

		return "admin-page/v1/categories/deleted";
	}

	// restore deleted category
	@GetMapping(path = "/restore")
	String restoreDeleted(@RequestParam String id) {
		this.categoryService.restore(Integer.parseInt(id));

		return "admin-page/v1/categories/deleted";
	}

	// add new category page
	@GetMapping(path = "/add")
	String addPage(Model model) {
		model.addAttribute("category", new Category());
		model.addAttribute("categoryTypes", this.categoryTypeService.findAll());

		return "admin-page/v1/categories/add";
	}

	// add new category
	@PostMapping(path = "/add")
	String addUser(
			@ModelAttribute("category") Category category, // this is the bean
			Model model, 
			HttpServletRequest request, 
			RedirectAttributes redirectAttributes) throws IOException {
		
		CategoryType categoryType = this.categoryTypeService.findById(
				Integer.parseInt(request.getParameter("categoryTypeId")));
		this.categoryService.add(category, categoryType);
		redirectAttributes.addFlashAttribute("successAdd", 1);
		return "redirect:/admin/category/add";
	}
}
