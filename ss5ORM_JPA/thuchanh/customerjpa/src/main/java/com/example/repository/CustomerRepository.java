package com.example.repository;

import com.example.model.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Repository
public class CustomerRepository implements ICustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = entityManager.
                createQuery("select s from Customer as s", Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findById(long id) {
        TypedQuery<Customer> query = entityManager
                .createQuery("select c from Customer c where c.id =: id", Customer.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }

    @Override
    public void save(Customer customer) {
        if (customer.getId() != null) {
            entityManager.merge(customer);
        } else {
            entityManager.persist(customer);
        }
    }

    @Override
    public void remove(long id) {
        Customer customer = findById(id);
        if (customer != null){
            entityManager.remove(customer);
        }
    }
}
