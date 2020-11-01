package com.myclass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myclass.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
