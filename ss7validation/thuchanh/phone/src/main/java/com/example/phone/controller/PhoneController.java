package com.example.phone.controller;

import com.example.phone.model.Phone;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PhoneController {

    @GetMapping("/phone")
    public String index(Model model){
        model.addAttribute("phone",new Phone());
        return "input";
    }
    @PostMapping("/phone/input")
    public String check(@Valid @ModelAttribute Phone phone, BindingResult bindingResult,Model model){
        new Phone().validate(phone,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "input";
        }else {
            model.addAttribute("phone",phone);
            return "result";
        }
    }
}
