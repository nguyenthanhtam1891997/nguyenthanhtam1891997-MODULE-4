package com.example.casestudy.controller;

import com.example.casestudy.dto.CustomerDto;
import com.example.casestudy.model.customer.Customer;
import com.example.casestudy.service.customer.ICustomerService;
import com.example.casestudy.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;


    @GetMapping("")
    public String showList(Model model, @PageableDefault(value = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        model.addAttribute("customerList", customerService.findAllPage(pageable));
        return "customer/List";
    }

    @GetMapping("/add")
    public String addCustomer(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        return "customer/creat";
    }

    @PostMapping("/save")
    public String saveCustomer(@Valid @ModelAttribute CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
//        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerTypeList", customerTypeService.findAll());
            return "customer/creat";
        } else {
//                Customer customer1 = new Customer();
//                int customerTypeId = customerDto.getCustomerType();
//                CustomerType customerType = customerTypeService.findById(customerTypeId);
//                BeanUtils.copyProperties(customerDto,customer1);
//                customer1.setCustomerType(customerType);
//                customerService.save(customer1);
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("message", "creat ok");
            return "redirect:/customer";
        }


    }

    @GetMapping("/edit/{id}")
    public String editCustomer(@PathVariable Integer id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        model.addAttribute("customerTypeList", customerTypeService.findAll());

        return "customer/edit";

    }

    @PostMapping("/update")
    public String updateCustomer(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "update ok");
        return "redirect:/customer";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(RedirectAttributes redirectAttributes, @PathVariable Integer id) {
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("message", "delete ok");
        return "redirect:/customer";
    }

    @GetMapping("/search")
    public String searchCustomer(@RequestParam(name = "nameCustomer",required = false,defaultValue ="") String nameCustomer,
                                 Model model, @PageableDefault(value = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable,
                                 RedirectAttributes redirectAttributes) {

        if (customerService.findCustomerByName(nameCustomer, pageable).isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "not found");

        } else {
            model.addAttribute("customerList", customerService.findCustomerByName(nameCustomer, pageable));
        }
        return "customer/List";
    }

}
