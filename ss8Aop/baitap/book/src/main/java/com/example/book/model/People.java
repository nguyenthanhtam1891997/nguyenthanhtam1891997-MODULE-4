package com.example.book.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "people")
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String namePeople;


    @OneToMany(mappedBy = "people")
    private List<Book_People> book_people;


    public People() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamePeople() {
        return namePeople;
    }

    public void setNamePeople(String namePeople) {
        this.namePeople = namePeople;
    }

    public List<Book_People> getBook_people() {
        return book_people;
    }

    public void setBook_people(List<Book_People> book_people) {
        this.book_people = book_people;
    }
}
