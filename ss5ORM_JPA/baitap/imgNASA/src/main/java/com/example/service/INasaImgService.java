package com.example.service;

import com.example.model.NaSaImg;

import java.util.List;

public interface INasaImgService {
    List<NaSaImg> findAll();
    void save(NaSaImg naSaImg);
    NaSaImg findById(Long id);
    void update(NaSaImg naSaImg);
}
