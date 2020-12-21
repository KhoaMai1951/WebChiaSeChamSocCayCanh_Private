package com.myclass.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.entity.Post;
import com.myclass.entity.User;
import com.myclass.repository.PostRepository;
import com.myclass.repository.RoleRepository;
import com.myclass.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PostRepository postRepo;
	
	@Autowired
	RoleRepository roleRepository;

	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}
	
	public List<User> findAllDeleted() {
		return (List<User>) userRepository.findAllDeleted();
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

	public boolean save(User u, int roleId)   
	{
		User uTemp = new User();
		uTemp.setEmail(u.getEmail());
		uTemp.setPassword(u.getPassword());
		uTemp.setUsername(u.getUsername());
		uTemp.setRole(this.roleRepository.findById(roleId));
 

		try { 
			this.userRepository.save(uTemp);
		} 
		catch(javax.persistence.RollbackException e) { 
		    
		} 
		return false;
	}
	
	public boolean softDelete(int currentId, int targetId) {
		// if not delete admin himself
		if(currentId != targetId)
		{
			userRepository.softDelete(targetId);
			return true;
		}
		return false; 
	}
}
