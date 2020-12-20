package com.myclass.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
 
import com.myclass.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

	@Override
	@Query(value = "SELECT * FROM ROLES r", nativeQuery = true)
	List<Role> findAll();
	
	@Query(value = "SELECT * FROM ROLES r WHERE r.id = :id", nativeQuery = true)
	Role findById(@Param("id") int id);
}
