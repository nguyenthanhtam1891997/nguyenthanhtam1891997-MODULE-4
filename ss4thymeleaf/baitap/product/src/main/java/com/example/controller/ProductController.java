package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/Product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String index(Model model) {
        List<Product> productList = productService.findAll();

        model.addAttribute("productList", productList);

        return "index";
    }

    @GetMapping("/creat")
    public String creat(Model model) {
        model.addAttribute("product", new Product());
        return "creat";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        product.setId((int) (Math.random() * 100));
        productService.save(product);
        redirectAttributes.addFlashAttribute("messagett", "Creat ok");
        return "redirect:/Product";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }
    @PostMapping("/update")
    public String update(Product product,RedirectAttributes redirectAttributes){
        productService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("messagett","update ok");
        return "redirect:/Product";
    }
    @GetMapping("/delete/{id)")
    public String delete(@PathVariable int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "delete";
    }
    @PostMapping("/remove")
    public String remove(Product product,RedirectAttributes redirectAttributes){
        productService.remove(product.getId());
        redirectAttributes.addFlashAttribute("messagett","delete ok");
        return "redirect:/Product";
    }
    @GetMapping("/view/{id}")
    public String views(@PathVariable int id,Model model){
        model.addAttribute(productService.findById(id));
        return "view";
    }
    @GetMapping("/search")
    public String search(@RequestParam("search") String name, Model model){
      List<Product> productList= productService.findByName(name);
        model.addAttribute("productList",productList);
        return "index";
    }
}
