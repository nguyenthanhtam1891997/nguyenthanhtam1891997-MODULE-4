package com.example.controller;

import com.example.model.MailModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MailController {

    @GetMapping("/home")
        public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("home","mail",new MailModel());
        return modelAndView;
    }
    @PostMapping("/name")
    public ModelAndView submitValue(@ModelAttribute MailModel mailModel){
        ModelAndView modelAndView = new ModelAndView("/info");
        modelAndView.addObject("maiModel",mailModel);
        return modelAndView;
    }
}
