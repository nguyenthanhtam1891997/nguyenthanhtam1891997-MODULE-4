package com.example.productcookiesessien.controller;

import com.example.productcookiesessien.model.Cart;
import com.example.productcookiesessien.model.Product;
import com.example.productcookiesessien.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {

    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart innitCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public String showShop(Model model) {
        model.addAttribute("products", productService.findAll());
        return "shop";
    }

    @GetMapping("add/{id}")
    public String addToCart(@PathVariable Long id, @SessionAttribute("cart") Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }

    @GetMapping("remove/{id}")
    public String remove(@PathVariable Long id, @SessionAttribute("cart") Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.remove(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }

}
