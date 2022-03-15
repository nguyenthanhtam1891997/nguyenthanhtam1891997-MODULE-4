package com.example.customerbank.service;

import com.example.customerbank.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IGeneralService<T> {
    Page<T> findAll(Pageable pageable);

    T findById(int id);

    void save(T t);

    void remove(int id);
    List<T> findAll();

}
