package com.jjp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jjp.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
