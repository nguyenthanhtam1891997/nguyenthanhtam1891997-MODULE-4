package com.example.book.service;

import com.example.book.model.Book;

import java.util.List;

public interface IGeneralService<T> {
    List<T> findAll();

    void save(T t);

    T findById(int id);

    void remove(int id);
}
