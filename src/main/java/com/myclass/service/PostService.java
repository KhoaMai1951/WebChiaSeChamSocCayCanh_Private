package com.myclass.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.entity.Post;
import com.myclass.repository.PostRepository;

@Service
public class PostService {
	@Autowired
	PostRepository postRepo;
	
	public void save(Post post)
	{
		this.postRepo.save(post);
	}
}
