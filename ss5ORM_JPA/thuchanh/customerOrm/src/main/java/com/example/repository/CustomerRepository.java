package com.example.repository;

import com.example.model.Customer;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CustomerRepository implements ICustomerRepository{
    @Override
    public List<Customer> findAll() {
        Session session=null;
        List<Customer> customerList=null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
         customerList = session.createQuery("FROM Customer ").getResultList();
        }finally {
            if (session !=null){
                session.close();
            }
        }



        return customerList;
    }

    @Override
    public Customer findOne(Long id) {
        return null;
    }

    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public List<Customer> save(List<Customer> customers) {
        return null;
    }

    @Override
    public boolean exists(Long id) {
        return false;
    }

    @Override
    public List<Customer> findAll(List<Long> ids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(Customer customer) {

    }

    @Override
    public void delete(List<Customer> customers) {

    }

    @Override
    public void deleteAll() {

    }
}
