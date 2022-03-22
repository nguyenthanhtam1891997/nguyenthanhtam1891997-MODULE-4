package com.example.login.controller;

import com.example.login.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {


    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user",new User());
        return "login";
    }
    @PostMapping("/doLogin")
    public String doLogin(User user,Model model){
        if (user.getUsername().equals("admin")&&user.getPassword().equals("12345")){
            model.addAttribute("user",user);
            return "success";
        }else {
            return "error";
        }
    }
}
