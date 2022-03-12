package com.example.book.repository;

import com.example.book.model.Book_People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookPeopleRepository extends JpaRepository<Book_People,Integer> {
    Book_People findByCodeBook(String coderBook);

}
