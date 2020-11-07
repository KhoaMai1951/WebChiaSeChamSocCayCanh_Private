package com.myclass.entity;

import javax.persistence.Entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Table;


@Entity(name = "images")
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "url")
	private String url;

	@Column(name = "is_deleted")
	private boolean isDeleted;

	@OneToOne(mappedBy = "image")
	private Post post;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public boolean isDeleted() {
		return isDeleted;
	}


	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}


//	public Post getPost() {
//		return post;
//	}
//
//
//	public void setPost(Post post) {
//		this.post = post;
//	}

}
