package com.myclass.repository;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.mapping.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myclass.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	@Query(value = "SELECT * FROM categories "
			+ "WHERE category_type_id = :category_type_id "
			+ "AND is_deleted = 0", nativeQuery = true)
	ArrayList<Category> findByCategoryTypeId(@Param("category_type_id") Integer categoryTypeId);

//	@Query(value = "SELECT * FROM categories "
//			+ "WHERE category_type_id = :category_type_id "
//			+ "AND is_deleted = 0", nativeQuery = true)
//	ArrayList<Category> findByPostId(@Param("category_type_id") Integer postId);
	
	//find all not deleted by post id
	@Query(value = "SELECT c.* FROM posts p " + 
			"INNER JOIN category_post pivot ON p.id = pivot.post_id " + 
			"INNER JOIN categories c ON c.id = pivot.category_id " + 
			"WHERE p.id = :postId " + 
			"AND c.is_deleted = 0", nativeQuery = true)
	List<Category> findAllNotDeletedByPostId(@Param("postId") String postId);
	
	@Query(value = "SELECT * FROM categories WHERE is_deleted = 0", nativeQuery = true)
	List<Category> findAll();
	
	@Query(value = "SELECT * FROM categories WHERE is_deleted = 1", nativeQuery = true)
	List<Category> findAllDeleted();
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE CATEGORIES c SET c.is_deleted = 1 WHERE c.id = :id", nativeQuery = true)
	void softDelete(@Param("id") int id);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE CATEGORIES c SET c.is_deleted = 0 WHERE c.id = :id", nativeQuery = true)
	void restore(@Param("id") int id);
}
