package com.myclass.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity(name = "categories")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 

	private String name;

	@Column(name = "is_deleted")
	private boolean isDeleted;

	@ManyToMany(mappedBy = "categories")
	private List<Post> posts;
	
	@ManyToOne
	@JoinColumn(name = "category_type_id")  
	private CategoryType categoryType;

	public CategoryType getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(CategoryType categoryType) {
		this.categoryType = categoryType;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	} 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

}
