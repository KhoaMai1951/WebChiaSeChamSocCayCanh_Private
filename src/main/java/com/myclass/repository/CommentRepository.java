package com.myclass.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myclass.entity.Comment; 

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

	@Override
	@Query(value = "SELECT * FROM COMMENTS c WHERE c.is_deleted = 0", nativeQuery = true)
	List<Comment> findAll();
	
	@Query(value = "SELECT * FROM COMMENTS c WHERE c.is_deleted = 1", nativeQuery = true)
	List<Comment> findAllDeleted();
	
	@Query(value = "SELECT * FROM COMMENTS c WHERE c.is_deleted = 0 AND c.post_id = :postId", nativeQuery = true)
	List<Comment> getCommentsNotDeletedByPostId(@Param("postId") String postId);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE COMMENTS c SET c.is_deleted = 1 WHERE c.id = :id", nativeQuery = true)
	void softDelete(@Param("id") int id);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE COMMENTS c SET c.is_deleted = 0 WHERE c.id = :id", nativeQuery = true)
	void restore(@Param("id") int id);
}
