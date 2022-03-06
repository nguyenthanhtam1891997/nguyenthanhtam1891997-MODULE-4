package com.example.repository;

import com.example.model.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


public class CustomerRepository  {
//    private EntityManager entityManager;
//
//
//    @Override
//    public List<Customer> findAll() {
//        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c", Customer.class);
//        return query.getResultList();
//    }
//
//    @Override
//    public Customer findById(long id) {
//        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c where c.id=:id", Customer.class);
//        query.setParameter("id", id);
//        try {
//            return query.getSingleResult();
//        } catch (NoResultException e) {
//            return null;
//        }
//
//    }
//
//    @Override
//    public void save(Customer customer) {
//
//            entityManager.persist(customer);
//
//
//    }
//
//    @Override
//    public void remove(long id) {
//        Customer customer = findById(id);
//        if (customer != null) {
//            entityManager.remove(customer);
//        }
//    }
}
