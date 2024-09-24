package com.books.dev.bookTest;

import com.books.dev.entities.Books;
import com.books.dev.repositories.BooksRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BookTeste {

    @Autowired
    private BooksRepository repository;

    @Test
    public void testeCreateBook() {

        Books books = new Books();
        books.setId(1L);
        books.setTitle("48 leis do poder");
        books.setAuthor("Robert Greene");
        books.setPublishing(" Viking Press");
        books.setPhoto("https://www.google.com.br/books/edition/As_48_leis_do_poder/DG3MEAAAQBAJ?hl=pt-BR&gbpv=0");
        repository.save(books);

        Books verifica = repository.findById(books.getId()).orElse(null);
        assertThat(verifica).isNotNull();
        assertThat(verifica.getTitle().equals("48 leis do poder"));
        assertThat(verifica.getId()).isEqualTo(1L);
    }
}
