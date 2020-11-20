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
import com.myclass.repository.PostRepository;

@Service
public class PostService {
	@Autowired
	PostRepository postRepo;

	public void save(Post post, 
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
		post.setId(postId);
		post.setCreatedDate(new Date(System.currentTimeMillis()));

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

		this.postRepo.save(post);
	}

	public List<Post> findAll() {
		return postRepo.findAll();
	}
	
	public List<Post> findAllDeleted() {
		return postRepo.findAllDeleted();
	}
	
	public Post findById(String id) {
		return postRepo.findById(id).get();
	}
	
	public void softDelete(String id) {
		postRepo.softDelete(id);
	}
	
	public void restore(String id) {
		postRepo.restore(id);
	}
}
