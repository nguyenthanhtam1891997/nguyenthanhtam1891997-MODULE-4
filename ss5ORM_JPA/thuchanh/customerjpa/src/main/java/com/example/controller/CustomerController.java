package com.example.controller;

import com.example.model.Customer;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public String index(Model model, Model model2) {
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customerList", customerList);
        model2.addAttribute("customer", new Customer());

        return "index";
    }

    //    @GetMapping("/creat")
//        public String  creat(Model model){
//        model.addAttribute("customer",new Customer());
//        return "creat";
//    }
    @PostMapping("/save")
    public String save(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "creat ok");
        return "redirect:/customer";

    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "edit ok");
        return "redirect:/customer";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id,RedirectAttributes redirectAttributes) {
        customerService.remove(id);

        redirectAttributes.addFlashAttribute("message","delete ok");
        return "redirect:/customer";
    }
    @GetMapping("/views/{id}")
    public String views(@PathVariable int id,Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "views";
    }
}
