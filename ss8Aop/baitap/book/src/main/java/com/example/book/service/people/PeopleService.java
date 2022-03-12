package com.example.book.service.people;

import com.example.book.model.People;
import com.example.book.repository.IPeopleRepository;
import com.example.book.service.people.IPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService implements IPeopleService {
    @Autowired
    private IPeopleRepository peopleRepository;

    @Override
    public List<People> findAll() {
        return peopleRepository.findAll();
    }

    @Override
    public void save(People people) {
        peopleRepository.save(people);
    }

    @Override
    public People findById(int id) {
        return peopleRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(int id) {
        peopleRepository.deleteById(id);
    }
}
