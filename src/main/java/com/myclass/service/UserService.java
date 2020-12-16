package com.myclass.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.entity.Post;
import com.myclass.entity.User;
import com.myclass.repository.PostRepository;
import com.myclass.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PostRepository postRepo;

	public ArrayList<User> findAll() {
		return (ArrayList<User>) userRepository.findAll();
	}

	public User findById(int id) {
		return userRepository.findById(id).get();
	}

	public int findUserByEmailAndPassword(User user) {
		String email = user.getEmail();
		String password = user.getPassword(); 

		User userTemp = this.userRepository.findUserIdByEmailAndPassword(email, password);
		if(userTemp != null)
		{
			return userTemp.getId();
		}
		return -1;
	}
	
	public int findAdminByEmailAndPassword(User user) {
		String email = user.getEmail(); 
		String password = user.getPassword(); 
		
		User userTemp = this.userRepository.findAdminIdByEmailAndPassword(email, password);
		if(userTemp != null)
		{ 
			return userTemp.getId();
		}
		return -1;
	}
	
	public User findUserByPostId(Post post)
	{
		return userRepository.findUserByPostId(post.getId());
	}

}
