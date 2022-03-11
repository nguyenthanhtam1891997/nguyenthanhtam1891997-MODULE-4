package com.example.customerbank.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "saving")
public class Saving {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate dateSubmit;
    private String period;
    private double money;
    @OneToMany(mappedBy = "saving")
    private Set<Customer> customers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateSubmit() {
        return dateSubmit;
    }

    public void setDateSubmit(LocalDate dateSubmit) {
        this.dateSubmit = dateSubmit;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
