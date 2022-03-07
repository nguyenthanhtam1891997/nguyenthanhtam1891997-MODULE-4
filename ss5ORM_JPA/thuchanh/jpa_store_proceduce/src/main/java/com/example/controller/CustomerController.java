package com.example.controller;

import com.example.model.Customer;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public String creat(Model model){
        model.addAttribute("customer",new Customer());
        return "creat";
    }
    @PostMapping("/save")
    public String save(Customer customer, RedirectAttributes redirectAttributes){
        customerService.insertWithStore(customer);
        redirectAttributes.addFlashAttribute("message","creat ok");
        return "redirect:/customer";
    }

}
