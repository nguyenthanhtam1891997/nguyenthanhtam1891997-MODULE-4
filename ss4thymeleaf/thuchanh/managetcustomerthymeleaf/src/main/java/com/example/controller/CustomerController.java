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
    @RequestMapping({"/customer"})
public class CustomerController {
    @Autowired
    private  ICustomerService customerService ;
    @GetMapping("")
    public String index(Model model){
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customerList",customerList);
        return "index";
    }

    @GetMapping("/creat")
    public String creat(Model model){
        model.addAttribute("customer",new Customer());
        return "create";
    }
    @PostMapping("/save")
    public String save(Customer customer , RedirectAttributes redirectAttributes){
        customer.setId((int) (Math.random()*10000));
        customerService.save(customer);
       redirectAttributes.addFlashAttribute("message","Creat success");
        return "redirect:/customer";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id,Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "edit";
    }
    @PostMapping("/update")
    public String update(Customer customer,RedirectAttributes redirectAttributes){
        customerService.update(customer.getId(), customer);
        redirectAttributes.addFlashAttribute("message","Update success");
        return "redirect:/customer";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id,Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "delete";
    }
    @PostMapping("/remove")
    public String remove(Customer customer,RedirectAttributes redirectAttributes){
        customerService.remove(customer.getId());
        redirectAttributes.addFlashAttribute("message","delete success");
        return "redirect:/customer";
    }

    @GetMapping("/view/{id}")
    public String views(@PathVariable int id,Model model){
        model.addAttribute(customerService.findById(id));
        return "views";
    }
}
