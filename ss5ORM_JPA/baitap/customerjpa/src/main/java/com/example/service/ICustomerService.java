package com.example.service;

import com.example.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService  {
    List<Customer> findAll();
    Optional<Customer> findById(int id);
    void save (Customer customer);
    void remove(int id);

}
