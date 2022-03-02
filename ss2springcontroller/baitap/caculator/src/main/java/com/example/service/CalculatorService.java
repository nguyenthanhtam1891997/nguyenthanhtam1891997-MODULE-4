package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public double resultCalculate(double num1,double num2,String calculate){
        double result=0;
        switch (calculate){
            case "+":
                result=num1+num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2 ;
                break;
            case "/":
                result = num1 / num2;
                break;
        }
        return result;
    }
}
