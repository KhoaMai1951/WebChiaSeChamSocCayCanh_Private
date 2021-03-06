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
	@Query(value = "SELECT * FROM POSTS p WHERE p.is_deleted = 0 ORDER BY p.created_date DESC", nativeQuery = true)
	List<Post> findAll();
 
	@Query(value = "SELECT * FROM posts p  " + 
			"WHERE p.content LIKE :condition||'%' " + 
			"OR p.title LIKE :condition||'%' " + 
			"AND p.is_deleted = 0 " + 
			"ORDER BY p.created_date DESC", nativeQuery = true)
	List<Post> searchPost(@Param("condition") String condition);
	
	@Query(value = "SELECT P.* FROM " + 
			"posts P INNER JOIN users U " + 
			"ON P.user_id = U.id AND U.role_id = 2 AND p.is_deleted = 0", nativeQuery = true)
	List<Post> findAllByAdmin();
	
	@Query(value = "SELECT P.* FROM " + 
			"posts P INNER JOIN users U " + 
			"ON P.user_id = U.id AND U.role_id = 1 AND p.is_deleted = 0", nativeQuery = true)
	List<Post> findAllByUser();
	
	@Query(value = "SELECT p.*, u.role_id FROM POSTS p LEFT JOIN users u " + 
			"ON p.user_id = u.id " + 
			"WHERE u.role_id = 2 AND p.is_deleted = 1", nativeQuery = true)
	List<Post> findAllNewsDeleted();
	
	@Query(value = "SELECT p.*, u.role_id FROM POSTS p LEFT JOIN users u " + 
			"ON p.user_id = u.id " + 
			"WHERE u.role_id = 1 AND p.is_deleted = 1", nativeQuery = true)
	List<Post> findAllPostsDeleted();
	
	@Query(value = "SELECT P.* FROM posts P "
			+ "INNER JOIN users U "
			+ "ON P.user_id = U.id AND U.role_id = 2 AND p.is_deleted = 1", nativeQuery = true)
	List<Post> findAllByAdminDeleted();
	
	@Query(value = "SELECT P.* FROM posts P "
			+ "INNER JOIN users U "
			+ "ON P.user_id = U.id AND U.role_id = 1 AND p.is_deleted = 1", nativeQuery = true)
	List<Post> findAllByUserDeleted();
	
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
