package com.myclass.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
 
import com.myclass.entity.CategoryType; 

@Repository
public interface CategoryTypeRepository extends JpaRepository<CategoryType, Integer>{

	@Query(value = "SELECT * FROM category_types WHERE is_deleted = 0", nativeQuery = true)
	List<CategoryType> findAll();
}
