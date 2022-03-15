package com.example.customerbank.service.saving;

import com.example.customerbank.model.Saving;
import com.example.customerbank.repository.ISavingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavingService implements ISavingService {
    @Autowired
    private ISavingRepository savingRepository;

    @Override
    public Page<Saving> findAll(Pageable pageable) {
        return savingRepository.findAll(pageable);
    }

    @Override
    public Saving findById(int id) {
        return savingRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Saving saving) {
        savingRepository.save(saving);
    }

    @Override
    public void remove(int id) {
        savingRepository.deleteById(id);
    }

    @Override
    public List<Saving> findAll() {
        return savingRepository.findAll();
    }
}
