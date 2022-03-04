package com.example.service;

import com.example.model.Customer;
import com.example.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findOne(Long id) {
        return customerRepository.findOne(id);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> save(List<Customer> customers) {
        return customerRepository.save(customers);
    }

    @Override
    public boolean exists(Long id) {
        return customerRepository.exists(id);
    }

    @Override
    public List<Customer> findAll(List<Long> ids) {
        return customerRepository.findAll();
    }

    @Override
    public long count() {
        return customerRepository.count();
    }

    @Override
    public void delete(Long id) {
        customerRepository.delete(id);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public void delete(List<Customer> customers) {
        customerRepository.delete(customers);
    }

    @Override
    public void deleteAll() {
        customerRepository.deleteAll();
    }
}
