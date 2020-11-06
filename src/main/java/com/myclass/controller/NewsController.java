package com.myclass.controller;


import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.myclass.constant.PathConstant;
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

	// show add news page
	@GetMapping(path = "/add")
	String addNews(Model model) {

		model.addAttribute("plantCategories", categoryService.findByCategoryTypeId(1));
		model.addAttribute("contentCategories", categoryService.findByCategoryTypeId(2));
		model.addAttribute("post", new Post());
		return "admin-page/v1/news/add";
	}

	// add news
	@PostMapping(path = "/add", consumes = {"multipart/form-data"})
	String postAddNews(@ModelAttribute Post post, 
			Model model, 
			HttpServletRequest request,
			@RequestPart("imageUpload") MultipartFile file) {
        
		String path = FileSystems.getDefault()
		        .getPath("")
		        .toAbsolutePath()
		        .toString();

        try {
            var fileName = file.getOriginalFilename();
            var is = file.getInputStream();

            Files.copy(is, Paths.get(path + PathConstant.IMAGE_DIRECTORY + fileName),
                    StandardCopyOption.REPLACE_EXISTING);
            	
        } catch (IOException e) {

           
        }
        
		//this.postService.save(post, request, categoryService);
		return "admin-page/v1/index";
	}
}
