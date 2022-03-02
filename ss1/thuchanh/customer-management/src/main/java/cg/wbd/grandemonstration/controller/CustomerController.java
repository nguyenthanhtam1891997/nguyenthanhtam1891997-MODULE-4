package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.service.CustomerService;
import cg.wbd.grandemonstration.service.impl.SimpleCustomerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
//    private CustomerService customerService = new SimpleCustomerServiceImpl();
    @GetMapping("/")
    public String showList() {
        return "list";
    }
    @GetMapping("/info")
    public String ShowInfo(){
        return "info";
    }
}
