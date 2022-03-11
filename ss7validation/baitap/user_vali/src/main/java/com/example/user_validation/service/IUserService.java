package com.example.user_validation.service;

import com.example.user_validation.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    Page<User> findAll(Pageable pageable);

    void save(User user);

    User findById(int id);

    void remove(int id);


}
