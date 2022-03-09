package com.example.customerspringboot.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IGeneralService <T>{
Iterable<T> findAll();
Optional<T> findById(Long id);
void save (T t);
void remove(Long id);
Page<T> findAll(Pageable pageable);
}
