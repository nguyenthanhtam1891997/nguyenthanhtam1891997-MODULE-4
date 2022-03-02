package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculateController {
    @GetMapping("/")
 public String home(){
        return "home";
 }
 @PostMapping("/")
 public String convert(@RequestParam double rate,double creat ,Model model){
        double convert = rate * creat;
        model.addAttribute("convert",convert);
        return "home";
 }

}
