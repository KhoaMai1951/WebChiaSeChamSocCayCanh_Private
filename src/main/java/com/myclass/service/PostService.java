package com.myclass.service;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.myclass.constant.PathConstant;
import com.myclass.entity.Category;
import com.myclass.entity.Image;
import com.myclass.entity.Post;
import com.myclass.entity.User;
import com.myclass.repository.PostRepository;

@Service
public class PostService {
	@Autowired
	PostRepository postRepo;

	public Post save(
			Post post, 
			int userId,
			HttpServletRequest request, 
			CategoryService categoryService, 
			MultipartFile file) throws IOException {

		// image handle
		String path = FileSystems.getDefault().getPath("").toAbsolutePath().toString();

		var fileName = UUID.randomUUID().toString() + ".png";
		var is = file.getInputStream();

		Files.copy(is, Paths.get(path + PathConstant.IMAGE_DIRECTORY + fileName), 
				StandardCopyOption.REPLACE_EXISTING);

		Image image = new Image();
		image.setUrl(PathConstant.DATABASE_IMAGE_DIRECTORY + fileName);

		post.setImage(image);

		// the rest
		String postId = UUID.randomUUID().toString();
		User userTemp = new User();
		userTemp.setId(userId);
		post.setId(postId);
		post.setCreatedDate(new Date(System.currentTimeMillis()));
		post.setUser(userTemp);
		

		// create category objects
		List<String> lst = Collections.list(request.getParameterNames());
		List<Category> categories = new ArrayList<Category>();
		lst.forEach(x -> {
			if (x.contains("plantCategory")) {
				int id = Integer.parseInt(x.substring("plantCategory".length()));
				categories.add(categoryService.findById(id));
			} else if (x.contains("contentCategory")) {
				int id = Integer.parseInt(x.substring("contentCategory".length()));
				categories.add(categoryService.findById(id));
			}
		});

		post.setCategories(categories);

		return this.postRepo.save(post);
	}
	
	public Post update(
			Post post,  
			HttpServletRequest request, 
			CategoryService categoryService ) throws IOException {
  
		// get object by id
		Post postTemp = this.findById(post.getId());

		// set new title and content
		postTemp.setTitle(post.getTitle());
		postTemp.setContent(post.getContent());

		// set new categories
		List<String> lst = Collections.list(request.getParameterNames());
		List<Category> categories = new ArrayList<Category>();
		lst.forEach(x -> {
			if (x.contains("plantCategory")) {
				int id = Integer.parseInt(x.substring("plantCategory".length()));
				categories.add(categoryService.findById(id));
			} else if (x.contains("contentCategory")) {
				int id = Integer.parseInt(x.substring("contentCategory".length()));
				categories.add(categoryService.findById(id));
			}
		});
		postTemp.setCategories(categories);

		// update
		return this.postRepo.save(postTemp);
	}

	public List<Post> findAll() {
		return postRepo.findAll();
	}
	
	public List<Post> findAllByAdmin() {
		return postRepo.findAllByAdmin();
	}
	
	public List<Post> findAllByUser() {
		return postRepo.findAllByUser();
	}
	
	public List<Post> findAllNewsDeleted() {
		return postRepo.findAllNewsDeleted();
	}
	
	public List<Post> findAllPostsDeleted() {
		return postRepo.findAllPostsDeleted();
	}
	
	public List<Post> findAllByUserId(int id) {
		return postRepo.findAllByUserId(id);
	}
	
	public List<Post> findAllByUserComment(int id) {
		return postRepo.findAllByUserComment(id);
	}
	
	public List<Post> findAllByCategoryId(int id) {
		return postRepo.findAllByCategoryId(id);
	}
	
	public Post findById(String id) {
		return postRepo.findById(id).get();
	}
	
	
	public void softDelete(String id) {
		postRepo.softDelete(id);
	}
	
	public void deleteById(String id) {
		postRepo.deleteById(id);
	}
	
	public void restore(String id) {
		postRepo.restore(id);
	}
}
