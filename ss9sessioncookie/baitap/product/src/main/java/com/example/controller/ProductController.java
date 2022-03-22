package com.example.controller;

import com.example.model.Cart;
import com.example.model.Product;
import com.example.service.IProductService;
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
        model.addAttribute("productList", productService.findAll());
        return "shop";
    }

    @GetMapping("add/{id}")
    public String addToCart(@PathVariable Integer id, @SessionAttribute("cart") Cart cart, @RequestParam("action") String action) {
        Product product = productService.findById(id);
        if (product == null) {
            return "error.404";
        }
        if (action.equals("show")) {
            cart.addProduct(product);
            return "redirect:/shopping-cart";
        }
        cart.addProduct(product);
        return "redirect:/shop";
    }

    @GetMapping("/shopping-cart")
    public String showCart(@SessionAttribute("cart") Cart cart, Model model) {
        model.addAttribute("cart", cart);
        return "/cart";
    }
    @GetMapping("remove/{id}")
    public String remove(@PathVariable Integer id,@SessionAttribute("cart") Cart cart,@RequestParam("action")String action){
        Product product = productService.findById(id);

        if (product == null) {
            return "error.404";
        }
        if (action.equals("show")) {
            cart.addProduct(product);
            return "redirect:/shopping-cart";
        }
        cart.removeProduct(product);
        return "redirect:/shop";

    }
}
