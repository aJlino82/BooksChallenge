package com.books.dev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.books.dev.entities.Book;

public interface BooksRepository extends JpaRepository<Book, Long> {

}
