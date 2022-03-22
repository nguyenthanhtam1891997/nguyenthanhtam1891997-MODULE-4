package com.example.casestudy.service.customer;

import com.example.casestudy.model.customer.Customer;
import com.example.casestudy.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService extends IGeneralService<Customer> {
//    List<Customer> findByNameContaining(String name);
    Page<Customer> findCustomerByName(String name, Pageable pageable);
}
