package com.myclass.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.entity.Comment;
import com.myclass.entity.Post;
import com.myclass.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	CommentRepository commentRepo;
	
	public ArrayList<Comment> findAll() {
		return (ArrayList<Comment>) commentRepo.findAll();
	}
	
	public ArrayList<Comment> findAllDeleted() {
		return (ArrayList<Comment>) commentRepo.findAllDeleted();
	}
	
	public void softDelete(int id) {
		commentRepo.softDelete(id);
	}
	 
	public List<Comment> getCommentsNotDeletedByPostId(String postId) {
		return commentRepo.getCommentsNotDeletedByPostId(postId);
	}
	
	public void restore(int id) {
		commentRepo.restore(id);
	}
}
