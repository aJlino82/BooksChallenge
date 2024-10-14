package com.books.dev.mocks;

import com.books.dev.entities.Book;
import com.books.dev.services.BooksServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MockBook implements CommandLineRunner {


    private final BooksServiceImpl service;

    public MockBook(BooksServiceImpl service) {
        this.service = service;
    }

    @Override
    public void run(String... args) throws Exception {
        Book book = new Book();
        book.setTitle("48 leis do poder");
        book.setAuthor("Robert Greene");
        book.setPublishing("Viking Press");
        book.setPhoto("https://www.google.com.br/books/edition/As_48_leis_do_poder/DG3MEAAAQBAJ?hl=pt-BR&gbpv=0");
        service.create(book);

        Book book2 = new Book();
        book2.setTitle("Viagem ao Centro da Terra");
        book2.setAuthor("Júlio Verne");
        book2.setPublishing("Pierre-Jules Hetzel");
        book2.setPhoto("https://www.google.com.br/books/edition/Viagem_ao_centro_da_Terra/eRD9EAAAQBAJ?hl=pt-BR&gbpv=1&printsec=frontcover");
        service.create(book2);
    }

}
