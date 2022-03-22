package com.example.casestudy.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {

    List<T> findAll();

    Page<T> findAllPage(Pageable pageable);

    T findById(Integer id);

    T save(T t);

    void remove(Integer id);

}
