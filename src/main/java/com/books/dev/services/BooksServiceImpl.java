package com.books.dev.services;

import com.books.dev.entities.Books;
import com.books.dev.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServiceImpl implements BooksServiceInterface {

    @Autowired
    BooksRepository booksRepository;

    @Override
    public Books getBookById(Long id) {
        return booksRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id " + id));
    }

    @Override
    public Books createBook(Books book) {
        return booksRepository.save(book);
    }

    @Override
    public Books updateBook(Long id, Books book) {
        Books existingBook = booksRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id " + id));

        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setPublishing(book.getPublishing());
        existingBook.setPhoto(book.getPhoto());

        return booksRepository.save(existingBook);
    }

    @Override
    public void deleteBook(Long id) {
        Books book = booksRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id " + id));
        booksRepository.delete(book);
    }

    public List<Books> getAllBooks() {
        return booksRepository.findAll();
    }
}
