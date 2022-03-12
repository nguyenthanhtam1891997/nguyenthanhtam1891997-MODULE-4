package com.example.book.service.book_people;

import com.example.book.model.Book_People;
import com.example.book.service.IGeneralService;

public interface IBookPeopleService extends IGeneralService<Book_People> {
    Book_People findByCodeBook(String coderBook);
}
