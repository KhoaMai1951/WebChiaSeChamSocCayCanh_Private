package com.myclass.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	RoleRepository roleRepo;
	
	
}
