package com.myclass.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.entity.User;
import com.myclass.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public ArrayList<User> findAll()
	{
		return (ArrayList<User>) userRepository.findAll();
	} 
	
	public User findById(int id)
	{
		return userRepository.findById(id).get();
	}
}
