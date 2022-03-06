package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import cg.wbd.grandemonstration.service.impl.SimpleCustomerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {
    private CustomerService customerService = new SimpleCustomerServiceImpl();
    @GetMapping("/")
    public String showList(Model model,Model model2) {
       List<Customer>customerList= customerService.findAll();
       model.addAttribute("customers",customerList);
       model2.addAttribute("count",customerService.count());

        return "list";
    }
    @GetMapping("/info")
    public String ShowInfo(){
        return "info";
    }
}
