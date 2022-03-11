package com.example.customerbank.repository;

import com.example.customerbank.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
}
