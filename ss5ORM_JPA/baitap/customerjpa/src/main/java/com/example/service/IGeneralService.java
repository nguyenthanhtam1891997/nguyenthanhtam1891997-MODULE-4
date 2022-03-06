package com.example.service;

import java.util.List;

public interface IGeneralService<T> {
    List<T> findAll();
    T findById(long id);
    void save (T t);
    void remove(long id);
}
