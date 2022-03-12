package com.example.book.service.book_people;

import com.example.book.model.Book_People;
import com.example.book.repository.IBookPeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookPeopleService implements IBookPeopleService{
    @Autowired
    private IBookPeopleRepository bookPeopleRepository;
    @Override
    public List<Book_People> findAll() {
        return bookPeopleRepository.findAll();
    }

    @Override
    public void save(Book_People book_people) {
bookPeopleRepository.save(book_people);
    }

    @Override
    public Book_People findById(int id) {
        return bookPeopleRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(int id) {
        bookPeopleRepository.deleteById(id);
    }

    @Override
    public Book_People findByCodeBook(String coderBook) {
        return bookPeopleRepository.findByCodeBook(coderBook);
    }
}
