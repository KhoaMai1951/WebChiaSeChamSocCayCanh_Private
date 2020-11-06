package com.myclass.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.entity.Category;
import com.myclass.entity.Post;
import com.myclass.repository.PostRepository;

@Service
public class PostService {
	@Autowired
	PostRepository postRepo;
	
	
	public void save(Post post, HttpServletRequest request, CategoryService categoryService)
	{
		String postId = UUID.randomUUID().toString();
		post.setId(postId);
		post.setCreatedDate(new Date(System.currentTimeMillis()));

		// create category objects 
		List<String> lst = Collections.list(request.getParameterNames());
		List<Category> categories = new ArrayList<Category>();
		lst.forEach(x -> {
			if (x.contains("plantCategory")) {
				int id = Integer.parseInt(x.substring("plantCategory".length()));
				categories.add(categoryService.findById(id));
			} else if (x.contains("contentCategory")) {
				int id = Integer.parseInt(x.substring("contentCategory".length()));
				categories.add(categoryService.findById(id));
			}
		});

		post.setCategories(categories);
		
		this.postRepo.save(post);
	}
	
	
}
