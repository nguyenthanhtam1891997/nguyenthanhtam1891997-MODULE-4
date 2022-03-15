package com.example.customerbank.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "customer")
    private Set<Saving> saving;

    public Customer() {
    }

    public Set<Saving> getSaving() {
        return saving;
    }

    public void setSaving(Set<Saving> saving) {
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
