package com.books.dev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.books.dev.entities.Books;

public interface BooksRepository extends JpaRepository<Books, Long> {

}
