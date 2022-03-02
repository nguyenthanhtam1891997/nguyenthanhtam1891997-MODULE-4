package com.example.repository;

import com.example.model.Login;
import com.example.model.User;
import org.springframework.stereotype.Repository;


public interface IUserDao {
     User checkLogin(Login login);
}
