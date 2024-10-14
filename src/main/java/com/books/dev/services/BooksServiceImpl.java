package com.books.dev.services;

import com.books.dev.entities.Book;
import com.books.dev.repositories.BooksRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServiceImpl implements BooksServiceInterface<Book, Long> {


    private final BooksRepository booksRepository;

    public BooksServiceImpl(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    public Book getById(Long id) {
        return booksRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id " + id));
    }

    @Override
    public Book create(Book book) {
        return booksRepository.save(book);
    }

    @Override
    public Book update(Long id, Book book) {
        Book existingBook = booksRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id " + id));

        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setPublishing(book.getPublishing());
        existingBook.setPhoto(book.getPhoto());

        return booksRepository.save(existingBook);
    }

    @Override
    public void delete(Long id) {
        Book book = booksRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id " + id));
        booksRepository.delete(book);
    }

    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }
}
