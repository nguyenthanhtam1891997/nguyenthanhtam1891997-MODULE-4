package com.example.productcookiesessien.service;

import com.example.productcookiesessien.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);

}
