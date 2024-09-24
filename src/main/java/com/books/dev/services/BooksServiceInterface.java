package com.books.dev.services;

import com.books.dev.entities.Books;

public interface BooksServiceInterface {
    Books getBookById(Long id);

    Books createBook(Books book);

    Books updateBook(Long id, Books book);

    void deleteBook(Long id);
}
