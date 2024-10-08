package com.books.dev.controllers;

import com.books.dev.entities.Books;
import com.books.dev.services.BooksServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/obras")
public class BookController {

    @Autowired
    private BooksServiceImpl bookService;

    @GetMapping("/{id}")
    public ResponseEntity<Books> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PostMapping
    public ResponseEntity<Books> createBook(@RequestBody Books book) {
        return ResponseEntity.ok(bookService.createBook(book));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Books> updateBook(@PathVariable Long id, @RequestBody Books book) {
        return ResponseEntity.ok(bookService.updateBook(id, book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Books>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Books> updatePatchBook(@PathVariable Long id, @RequestBody Books book) {
        return ResponseEntity.ok(bookService.updateBook(id, book));
    }
}
