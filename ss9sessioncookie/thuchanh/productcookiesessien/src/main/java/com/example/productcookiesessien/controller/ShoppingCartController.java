package com.example.productcookiesessien.controller;

import com.example.productcookiesessien.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ShoppingCartController {


    @GetMapping("/shopping-cart")
    public String showCart(@SessionAttribute(value = "cart",required = false)Cart cart, Model model){
        model.addAttribute("cart",cart);
        return "cart";
    }
}
