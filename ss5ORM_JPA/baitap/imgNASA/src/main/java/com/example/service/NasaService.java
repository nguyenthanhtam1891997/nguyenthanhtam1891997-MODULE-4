package com.example.service;

import com.example.model.NaSaImg;
import com.example.repository.INasaImgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NasaService implements INasaImgService{
    @Autowired
    private INasaImgRepository nasaImgRepository;
    @Override
    public List<NaSaImg> findAll() {
        return nasaImgRepository.findAll();
    }

    @Override
    public void save(NaSaImg naSaImg) {
        nasaImgRepository.save(naSaImg);
    }

    @Override
    public NaSaImg findById(Long id) {
        return nasaImgRepository.findById(id);
    }

    @Override
    public void update(NaSaImg naSaImg) {
        nasaImgRepository.update(naSaImg);
    }
}
