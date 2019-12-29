package com.jjp.service;

import java.util.List;

import com.jjp.model.Book;

public interface BookService {
	
	public List<Book> getAllBooks();
	
	public void addBooks(Book book);
	
	public void deleteBooks(int id);
	
	public void recoverBooks(int id);
}
