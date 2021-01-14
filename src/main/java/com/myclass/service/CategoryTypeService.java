package com.myclass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.myclass.entity.CategoryType;
import com.myclass.repository.CategoryTypeRepository;

@Service
public class CategoryTypeService {

	@Autowired
	CategoryTypeRepository categoryTypeRepo;
	
	public List<CategoryType> findAll()
	{
		return this.categoryTypeRepo.findAll();
	}
	
	public CategoryType findById(int id)
	{
		return this.categoryTypeRepo.findById(id).get();
	}
	
}
