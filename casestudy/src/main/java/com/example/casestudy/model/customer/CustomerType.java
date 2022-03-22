package com.example.casestudy.model.customer;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customertype")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String customerTypeName;

    @OneToMany(mappedBy = "customerType")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Customer> customers;

    public CustomerType() {
    }


    public CustomerType(String customerTypeName, Set<Customer> customers) {
        this.customerTypeName = customerTypeName;
        this.customers = customers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
