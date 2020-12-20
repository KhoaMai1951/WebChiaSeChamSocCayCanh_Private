package com.myclass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.entity.Role;
import com.myclass.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	RoleRepository roleRepo;
	
	public List<Role> findAll(){
		return this.roleRepo.findAll();
	}
}
