package com.example.casestudy.service.customer.impl;

import com.example.casestudy.model.customer.Customer;
import com.example.casestudy.repository.ICustomerRepository;
import com.example.casestudy.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> findAllPage(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void remove(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findCustomerByName(String name, Pageable pageable) {
        return customerRepository.findByNameContaining(name,pageable);
    }

//    @Override
//    public List<Customer> findByNameContaining(String name) {
//        return customerRepository.findByNameContaining(name);
//    }


}
