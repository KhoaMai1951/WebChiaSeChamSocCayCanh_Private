package com.myclass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myclass.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query(value = "SELECT * FROM users u WHERE u.is_deleted = 0 AND u.email = :email AND u.password = :password", nativeQuery = true)
	public User findUserIdByEmailAndPassword(@Param("email") String email, @Param("password") String password);
	
}
