package com.books.dev.controllers;

import com.books.dev.entities.Book;
import com.books.dev.services.BooksServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/obras")
public class BookControllerImpl implements AbstractControllerInterface<Book, Long> {


    private final BooksServiceImpl bookService;

    public BookControllerImpl(BooksServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Book>> getAll() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @PostMapping
    @Override
    public ResponseEntity<Book> create(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.create(book));
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Book> getById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getById(id));
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Book> update(@RequestBody Book book, @PathVariable Long id) {
        return ResponseEntity.ok(bookService.update(id, book));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
