package com.myclass.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.entity.Category;
import com.myclass.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepo;
	
	public ArrayList<Category> findByCategoryTypeId(int id)
	{
		return this.categoryRepo.findByCategoryTypeId(id);
	}
} 
