package com.example.controller;

import com.example.model.Login;
import com.example.model.User;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
  @Autowired
    IUserService userService;

    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView  = new ModelAndView("home","login",new Login());
    return modelAndView;
    }

    @PostMapping("/name")
    public ModelAndView login(@ModelAttribute Login login){
        User user = userService.checkLogin(login);
        if (user == null){
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("user");
            modelAndView.addObject("user",user);
            return modelAndView;
        }

    }
}
