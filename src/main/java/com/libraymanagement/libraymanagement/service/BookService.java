package com.libraymanagement.libraymanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraymanagement.libraymanagement.entity.Book;
import com.libraymanagement.libraymanagement.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public void save(Book b) {
		bookRepository.save(b);
	}
	
	public List<Book> getAllBook(){
		return bookRepository.findAll();
	}
	
	public Book getBookById(Long id) {
		return bookRepository.findById(id).get();
	}
	
	public void deleteById(Long id) {
		bookRepository.deleteById(id);
	}
	
	public Book get(Long id) {
		return bookRepository.findById(id).get();
	}
}
