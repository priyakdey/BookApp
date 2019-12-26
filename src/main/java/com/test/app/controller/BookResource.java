package com.test.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.app.model.Book;
import com.test.app.service.IBookservice;

@RestController
@RequestMapping(path = "/books", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
public class BookResource {

	private IBookservice bookService;
	
	@Autowired
	public BookResource(IBookservice bookService) {
		this.bookService = bookService;
	}


	@GetMapping("/{title}")
	public void getBookByTitle(@PathVariable String title) {
		Book book = this.bookService.getBookDetailsByTitle(title);
		new ResponseEntity<Book>(book, HttpStatus.FOUND);
	}
	
}
