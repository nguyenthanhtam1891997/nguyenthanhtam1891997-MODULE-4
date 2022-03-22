package com.example.blogsecurity.controller;


import com.example.blogsecurity.model.Category;
import com.example.blogsecurity.service.IBlogService;

import com.example.blogsecurity.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;


    @GetMapping("")
    public String listCategory(Model model,
                               @PageableDefault(value = 5,sort = "nameCategory",direction = Sort.Direction.ASC) Pageable pageable){
        model.addAttribute("categoryList",categoryService.findAll(pageable));
        return "listCategory";
    }
    @GetMapping("/creat")
    public String showCreatCategory(Model model){


        model.addAttribute("category",new Category());
        return "creatCategory";

    }
    @PostMapping("/save")
    public String saveCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes){
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message","creat ok");
        return "redirect:/category";
    }
    @GetMapping("/edit/{id}")
    public String editCategory(@PathVariable int id,Model model){
        model.addAttribute("category",categoryService.findById(id));
        return "editCategory";
    }
    @PostMapping("/update")
    public String updateCategory(@ModelAttribute Category category,RedirectAttributes redirectAttributes){
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message","update ok");
        return "redirect:/category";
    }
    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable int id,RedirectAttributes redirectAttributes){
        categoryService.remove(id);
        redirectAttributes.addFlashAttribute("message","delete ok");
        return "redirect:/category";
    }
    @GetMapping("/view/{id}")
    public String viewCategory(@PathVariable int id,Model model,@PageableDefault(value = 3,sort = "id",direction = Sort.Direction.ASC)Pageable pageable){
        model.addAttribute("category",categoryService.findById(id));
        model.addAttribute("blogList",blogService.findByCategoryId(id,pageable));
        return "viewCategory";
    }
}
