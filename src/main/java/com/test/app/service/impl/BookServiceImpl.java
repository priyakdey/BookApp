package com.test.app.service.impl;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.app.model.Book;
import com.test.app.repository.BookRepository;
import com.test.app.service.IBookservice;

@Service
@Transactional
public class BookServiceImpl implements IBookservice {

	private BookRepository bookRepository;
	
	@Autowired
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}


	@Override
	public Book getBookDetailsByTitle(String title) {
		try {
			return this.bookRepository.findByTitle(title).get();
		} catch (NoSuchElementException e) {
			throw new BookNotFoundException("Book is not in the catalog");
		}
	}

}
