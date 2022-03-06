package com.example.repository;

import com.example.model.NaSaImg;

import java.util.List;

public interface INasaImgRepository {
    List<NaSaImg> findAll();

    void save(NaSaImg naSaImg);

    NaSaImg findById(Long id);
    void update(NaSaImg naSaImg);
}
