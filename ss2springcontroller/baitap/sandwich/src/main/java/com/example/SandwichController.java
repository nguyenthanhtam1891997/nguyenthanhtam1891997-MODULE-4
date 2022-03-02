package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SandwichController {
    @GetMapping("/")
    String home(){
        return "index";
    }
    @PostMapping ("/sandwich")
    public ModelAndView getSandwich( @RequestParam(required = false) String[] list){
        ModelAndView  modelAndView = new ModelAndView("index") ;
//        for (String item:list){
//            if (item == "abc"){
//                modelAndView.addObject("message","sandwich have not Condiments");
//            }
//        }
        if (list != null){

                modelAndView.addObject("list",list);

        }else {
            modelAndView.addObject("check","Not Found");
        }

        return modelAndView;
    }
}
