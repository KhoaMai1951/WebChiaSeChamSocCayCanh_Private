package com.myclass.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.entity.Comment; 
import com.myclass.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	CommentRepository commentRepo;
	
	public ArrayList<Comment> findAll() {
		return (ArrayList<Comment>) commentRepo.findAll();
	}
}
