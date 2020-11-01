package com.myclass.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.repository.PostRepository;

@Service
public class PostService {
	@Autowired
	PostRepository postRepo;
	
	
}
