package com.example.customerbank.model;

import javax.persistence.*;

@Entity
@Table(name = "saving")
public class Saving {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String dateSubmit;
    private String period;
    private Double money;


   @ManyToOne
   @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer customer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateSubmit() {
        return dateSubmit;
    }

    public void setDateSubmit(String dateSubmit) {
        this.dateSubmit = dateSubmit;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customers) {
        this.customer = customers;
    }
}
