package com.myclass.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

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
import com.myclass.service.PostService;

@Controller
@RequestMapping("/admin/news")
public class NewsController {
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	PostService postService;
	
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
	String postAddNews(@ModelAttribute Post post, Model model, HttpServletRequest request) {
		// create post object
		String postId = UUID.randomUUID().toString();
		post.setId(postId);
		post.setCreatedDate(new Date(System.currentTimeMillis()));
		
		// create category objects
		List<String> lst = Collections.list(request.getParameterNames());
		List<Category> categories = new ArrayList<Category>();
		lst.forEach(x -> {
			if(x.contains("plantCategory"))
			{
				int id = Integer.parseInt(x.substring("plantCategory".length()));
				categories.add(this.categoryService.findById(id));
			}
			else if(x.contains("contentCategory"))
			{
				
			}
		});
		
		post.setCategories(categories);
		postService.save(post);
		return "admin-page/v1/index";
	}
}
