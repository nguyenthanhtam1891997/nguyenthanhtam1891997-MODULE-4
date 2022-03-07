package com.example.repository;

import com.example.model.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CustomerRepository implements ICustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean insertWithStore(Customer customer) {
//        String sql = "CALL Insert_Customer(:firstName, :lastName)";
        Query query = entityManager.createNativeQuery("call Insert_Customer(:firstname,:lastname)");
        query.setParameter("firstname", customer.getFirstName());
        query.setParameter("lastname", customer.getLastName());

        return query.executeUpdate() == 0;
    }
}
