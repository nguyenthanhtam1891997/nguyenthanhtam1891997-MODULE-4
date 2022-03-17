package com.example.phoneajax.service;

import com.example.phoneajax.model.Phone;

import java.util.List;

public interface IPhoneService {

    List<Phone> findAll();

    Phone findById(Long id);

    Phone save(Phone phone);

    void removeById(Long id);

}
