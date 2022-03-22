package com.example.casestudy.repository;

import com.example.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
//    List<Customer> findByNameContaining(String name);
    Page<Customer> findByNameContaining(String name, Pageable pageable);
}
