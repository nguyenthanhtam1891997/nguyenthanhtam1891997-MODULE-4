package com.example.book.repository;

import com.example.book.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPeopleRepository extends JpaRepository<People,Integer> {
}
