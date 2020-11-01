package com.myclass.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.myclass.entity.Book;
import com.myclass.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepo;
	
	public ArrayList<Book> findAll()
	{
		return (ArrayList<Book>) bookRepo.findAll();
	} 
	
	public Page<Book> findPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Book> list;
        ArrayList<Book> books = this.findAll();
 
        if (books.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, books.size());
            list = books.subList(startItem, toIndex);
        }
 
        Page<Book> bookPage
          = new PageImpl<Book>(list, PageRequest.of(currentPage, pageSize), books.size());
 
        return bookPage;
    }
}
