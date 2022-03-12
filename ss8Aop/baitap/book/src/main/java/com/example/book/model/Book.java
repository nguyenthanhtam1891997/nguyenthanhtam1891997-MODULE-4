package com.example.book.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameBook;
    private int amountBook;

    @OneToMany(mappedBy = "book")
    private List<Book_People> book_people;

    public Book() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public int getAmountBook() {
        return amountBook;
    }

    public void setAmountBook(int amountBook) {
        this.amountBook = amountBook;
    }

    public List<Book_People> getBook_people() {
        return book_people;
    }

    public void setBook_people(List<Book_People> book_people) {
        this.book_people = book_people;
    }
}
