package com.myclass.controller;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myclass.service.CategoryService;
import com.myclass.service.CommentService;
import com.myclass.service.PostService;

@Controller
@RequestMapping("/admin/news")
public class AdminUserController {
	@Autowired
	CategoryService categoryService;

	@Autowired
	PostService postService;
	
	@Autowired
	CommentService commentService;

	
}
