package com.myclass.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myclass.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {
	@Override
	@Query(value = "SELECT * FROM POSTS p WHERE p.is_deleted = 0", nativeQuery = true)
	List<Post> findAll();
	
	@Query(value = "SELECT * FROM POSTS p WHERE p.is_deleted = 1", nativeQuery = true)
	List<Post> findAllDeleted();
	
	@Query(value = "SELECT * FROM posts p WHERE p.user_id = :id AND p.is_deleted = 0", nativeQuery = true)
	List<Post> findAllByUserId(@Param("id") int id);
	
	@Query(value = "SELECT * FROM posts p " + 
			"INNER JOIN comments c ON p.id = c.post_id " + 
			"INNER JOIN users u ON u.id = c.user_id WHERE u.id = :id", nativeQuery = true)
	List<Post> findAllByUserComment(@Param("id") int id);
	
	@Query(value = "SELECT p.* FROM posts p " + 
			"LEFT JOIN category_post pivotal ON pivotal.post_id = p.id " + 
			"LEFT JOIN categories c ON pivotal.category_id = c.id " + 
			"WHERE c.id = :id AND p.is_deleted = 0", nativeQuery = true)
	List<Post> findAllByCategoryId(@Param("id") int id);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE POSTS p SET p.is_deleted = 1 WHERE p.id = :id", nativeQuery = true)
	void softDelete(@Param("id") String id);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE POSTS p SET p.is_deleted = 0 WHERE p.id = :id", nativeQuery = true)
	void restore(@Param("id") String id);
}
