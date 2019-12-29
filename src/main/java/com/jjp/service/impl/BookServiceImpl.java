package com.jjp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjp.model.Book;
import com.jjp.model.enums.BookStatusEnum;
import com.jjp.repository.BookRepository;
import com.jjp.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public void addBooks(Book book) {
		bookRepository.save(book);
	}

	@Override
	public void deleteBooks(int id) {
		Book book = bookRepository.getOne(id);
		book.setStatus(BookStatusEnum.DELETE.getValue());
		bookRepository.save(book);
	}

	@Override
	public void recoverBooks(int id) {
		Book book = bookRepository.getOne(id);
		book.setStatus(BookStatusEnum.NORMAL.getValue());
		bookRepository.save(book);
	}

}
