package com.books.dev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.dev.entities.Books;
import com.books.dev.repositories.BookRepository;

@RestController
@RequestMapping("/obras")
public class BookController {

	@Autowired
	BookRepository bookRepository;

	@PostMapping
	public Books addBook(@RequestBody Books entity) {
		return bookRepository.save(entity);
	}

	@GetMapping
	public List<Books> findAll() {
		return bookRepository.findAll();
	}

	/*@GetMapping("/{id}")
	public ResponseEntity<Books> findById(@PathVariable Long id) {
		return bookRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());

	}*/

	@PutMapping("/{id}")
	public ResponseEntity<Books> updateBook(@PathVariable("id") Long id, @RequestBody Books entity) {
		return bookRepository.findById(id).map(record -> {
			record.setAuthor(entity.getAuthor());
			record.setTitle(entity.getTitle());
			record.setPublishing(entity.getPublishing());
			Books updated = bookRepository.save(record);
			return ResponseEntity.ok().body(updated);

		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable("id") Long id) {
		return bookRepository.findById(id).map(record -> {
			bookRepository.deleteById(id);

			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
