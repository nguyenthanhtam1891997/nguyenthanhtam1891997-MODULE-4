package com.example.service;

import com.example.model.Login;
import com.example.model.User;
import com.example.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    private UserDao userDao;

    @Override
    public User checkLogin(Login login) {

        return userDao.checkLogin(login);
    }
}
