package com.example.controller;

import com.example.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    CalculatorService calculatorService ;
@GetMapping("/")
    public String indexPage(){
    return "index";
}
@PostMapping("/calculator")
    public String check(@RequestParam double num1, @RequestParam double num2, @RequestParam String calculate, Model model){
        double result = calculatorService.resultCalculate(num1,num2,calculate);
        model.addAttribute("result",result);
    return "index";
}
}
