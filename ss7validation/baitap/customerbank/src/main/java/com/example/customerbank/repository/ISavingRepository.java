package com.example.customerbank.repository;

import com.example.customerbank.model.Saving;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISavingRepository extends JpaRepository<Saving, Integer> {
}
