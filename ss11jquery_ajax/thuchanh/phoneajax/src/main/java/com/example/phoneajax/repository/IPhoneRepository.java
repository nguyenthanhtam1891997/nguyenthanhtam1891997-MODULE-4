package com.example.phoneajax.repository;

import com.example.phoneajax.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhoneRepository  extends JpaRepository<Phone,Long> {
}
