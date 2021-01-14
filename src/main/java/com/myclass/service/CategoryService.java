package com.myclass.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.entity.Category;
import com.myclass.entity.CategoryType;
import com.myclass.entity.User;
import com.myclass.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepo;
	
	public void add(Category category, CategoryType categoryType)
	{
		category.setCategoryType(categoryType);
		categoryRepo.save(category);
	}
	
	public ArrayList<Category> findByCategoryTypeId(int id)
	{
		return this.categoryRepo.findByCategoryTypeId(id);
	}
	
	public List<Category> findAll()
	{
		return this.categoryRepo.findAll();
	}
	
	public Category findById(int id)
	{
		return this.categoryRepo.findById(id).orElse(null);
	}
	
	public void softDelete(int id) {
		categoryRepo.softDelete(id);
	}
	
	public void restore(int id) {
		categoryRepo.restore(id);
	}
	
	public List<Category> findAllDeleted() {
		return (List<Category>) categoryRepo.findAllDeleted();
	} 
} 
