package com.books.dev.services;

import com.books.dev.entities.Book;

public interface BooksServiceInterface<T, ID> {
    Book getById(ID id);

    Book create(T entity);

    Book update(ID id, T entity);

    void delete(ID id);
}
