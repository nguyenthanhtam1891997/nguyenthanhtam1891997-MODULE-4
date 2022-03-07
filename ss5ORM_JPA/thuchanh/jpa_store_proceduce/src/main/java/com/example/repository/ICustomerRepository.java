package com.example.repository;

import com.example.model.Customer;

public interface ICustomerRepository {
    boolean insertWithStore(Customer customer);
}
