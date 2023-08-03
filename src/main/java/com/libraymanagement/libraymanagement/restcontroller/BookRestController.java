package com.libraymanagement.libraymanagement.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libraymanagement.libraymanagement.entity.Book;
import com.libraymanagement.libraymanagement.service.BookService;

@RestController
@RequestMapping(value = "/rest/book")
public class BookRestController {
	
	@Autowired
	private BookService service;
	
	@GetMapping("/allbooks")
	public List<Book> getAllBooksDetails() {
		return  service.getAllBook();
		//ModelAndView m=new ModelAndView();
		//m.setViewName("bookList");
		//m.addObject("book",list);
	}
	
	@GetMapping("/particularbook")
	public Book getBook(@PathVariable("id") Long id) {
		return service.getBookById(id);
		}

}
