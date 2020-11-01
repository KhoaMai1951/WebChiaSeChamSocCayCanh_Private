package com.myclass.repository;

import org.hibernate.mapping.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myclass.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
//	@Query(value = "SELECT * FROM USERS u WHERE u.status = 1", nativeQuery = true)
//	Collection<Category> findByCategoryTypeId();
}
