package com.example.customerbank.service;

import com.example.customerbank.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);

    Customer findById(int id);

    void save(Customer customer);

    void remove(int id);

}
