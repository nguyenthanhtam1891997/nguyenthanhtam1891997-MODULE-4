package com.example.service;

import com.example.model.Login;
import com.example.model.User;
import org.springframework.stereotype.Service;


public interface IUserService {
    User checkLogin(Login login);
}
