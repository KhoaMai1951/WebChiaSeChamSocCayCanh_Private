package com.myclass.controller;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.myclass.constant.PathConstant;
import com.myclass.entity.Category;
import com.myclass.entity.Post;
import com.myclass.service.CategoryService;
import com.myclass.service.PostService;

@Controller
@RequestMapping("/admin/news")
public class AdminNewsController {
	@Autowired
	CategoryService categoryService;

	@Autowired
	PostService postService;

	// news management page
	@GetMapping(path = "")
	String news(Model model) {
		model.addAttribute("posts", postService.findAll());

		return "admin-page/v1/news/index";
	}

	// show add news page
	@GetMapping(path = "/add")
	String addNews(Model model) {

		model.addAttribute("plantCategories", categoryService.findByCategoryTypeId(1));
		model.addAttribute("contentCategories", categoryService.findByCategoryTypeId(2));
		model.addAttribute("post", new Post());
		return "admin-page/v1/news/add";
	}

	// add news
	@PostMapping(path = "/add", consumes = { "multipart/form-data" })
	String postAddNews(@ModelAttribute Post post, Model model, HttpServletRequest request,
			@RequestPart("imageUpload") MultipartFile file) throws IOException {

		this.postService.save(post, request, categoryService, file);
		return "redirect:";
	}

	// show edit news page
	@GetMapping(path = "/edit/{id}")
	String editNews(Model model, @PathVariable(value = "id") String id) { 
		model.addAttribute("plantCategories", categoryService.findByCategoryTypeId(1));
		model.addAttribute("contentCategories", categoryService.findByCategoryTypeId(2));
		model.addAttribute("post", this.postService.findById(id));
		return "admin-page/v1/news/edit";
	}

	// soft delete
	@GetMapping(path = "/soft-delete")
	String softDelete(@RequestParam String id) {
		this.postService.softDelete(id);
		return "redirect:/admin/news";
	}

	// restore news
	@GetMapping(path = "/restore")
	String restore(@RequestParam String id) {
		this.postService.restore(id);
		return "redirect:/admin/news/deleted";
	}

	// show deletes news page
	@GetMapping(path = "/deleted")
	String restoreNewsPage(Model model) {

		model.addAttribute("posts", postService.findAllDeleted());
		return "admin-page/v1/news/deleted";
	}
	
	// show detail news page
	@GetMapping(path = "/detail")
	String detail(@RequestParam String id, Model model) {
		model.addAttribute("post", postService.findById(id));
		return "admin-page/v1/news/detail";
	}
}
