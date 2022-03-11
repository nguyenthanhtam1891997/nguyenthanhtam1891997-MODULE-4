package com.example.customerbank.model;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    @ManyToOne
    @JoinColumn(name = "saning_id",referencedColumnName = "id")
    private Saving saving;

    public Customer() {
    }

    public Saving getSaving() {
        return saving;
    }

    public void setSaving(Saving saving) {
        this.saving = saving;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
