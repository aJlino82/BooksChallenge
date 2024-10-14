package com.books.dev.controllers;


import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AbstractControllerInterface<T, ID> {

    public ResponseEntity<List<T>> getAll();

    public ResponseEntity<T> create(T entity);

    public ResponseEntity<T> getById(ID id);

    public ResponseEntity<T> update(T entity, ID id);

    public ResponseEntity<Void> delete(ID id);
}
