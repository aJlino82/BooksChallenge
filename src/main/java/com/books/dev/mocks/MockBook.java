package com.books.dev.mocks;

import com.books.dev.entities.Books;
import com.books.dev.services.BooksServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MockBook implements CommandLineRunner {

    @Autowired
    BooksServiceImpl service;


    @Override
    public void run(String... args) throws Exception {
        Books books = new Books();
        books.setTitle("48 leis do poder");
        books.setAuthor("Robert Greene");
        books.setPublishing("Viking Press");
        books.setPhoto("https://www.google.com.br/books/edition/As_48_leis_do_poder/DG3MEAAAQBAJ?hl=pt-BR&gbpv=0");
        service.createBook(books);

        Books books2 = new Books();
        books2.setTitle("Viagem ao Centro da Terra");
        books2.setAuthor("Júlio Verne");
        books2.setPublishing("Pierre-Jules Hetzel");
        books2.setPhoto("https://www.google.com.br/books/edition/Viagem_ao_centro_da_Terra/eRD9EAAAQBAJ?hl=pt-BR&gbpv=1&printsec=frontcover");
        service.createBook(books2);
    }

}
