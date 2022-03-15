package com.example.customerbank.controller;

import com.example.customerbank.model.Customer;
import com.example.customerbank.model.Saving;
import com.example.customerbank.repository.ICustomerRepository;
import com.example.customerbank.service.customer.ICustomerService;
import com.example.customerbank.service.saving.ISavingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@Controller
@RequestMapping("/bank")
public class BankController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ISavingService savingService;

    @GetMapping("")
    public String index(Model model, @PageableDefault(value = 3, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        model.addAttribute("savingList", savingService.findAll(pageable));
        model.addAttribute("saving",new Saving());
        model.addAttribute("customerList",customerService.findAll());
        return "list";
    }
    @PostMapping("/creat")
    public String create(@ModelAttribute Saving saving, RedirectAttributes redirectAttributes){
        saving.setDateSubmit(String.valueOf(new Date(System.currentTimeMillis())));
        customerService.save(saving.getCustomer());
        savingService.save(saving);
        redirectAttributes.addFlashAttribute("message","creat ok");
        return "redirect:/bank";
    }


}
