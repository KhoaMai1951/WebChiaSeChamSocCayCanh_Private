package com.myclass.repository;

import java.util.ArrayList;

import org.hibernate.mapping.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
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

}
