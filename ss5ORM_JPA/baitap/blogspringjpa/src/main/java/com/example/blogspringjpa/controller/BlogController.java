package com.example.blogspringjpa.controller;

import com.example.blogspringjpa.model.BlogTex;
import com.example.blogspringjpa.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String index(Model model) {
//        ModelAndView modelAndView=new ModelAndView("list");
//        modelAndView.addObject("blogList",blogService.findAll());
//        modelAndView.addObject("blog",new BlogTex());
        model.addAttribute("blogList", blogService.findAll());
        model.addAttribute("blog", new BlogTex());
        return "list";
    }

    @PostMapping("/save")
    public String save(BlogTex blogTex, RedirectAttributes redirectAttributes) {
        blogService.save(blogTex);
        redirectAttributes.addFlashAttribute("message", "save ok");
        return "redirect:/blog";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "edit";
    }
    @PostMapping("/update")
    public String update(BlogTex blogTex,RedirectAttributes redirectAttributes){
        blogService.save(blogTex);
        redirectAttributes.addFlashAttribute("message","update ok");
        return "redirect:/blog";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id,RedirectAttributes redirectAttributes){
        blogService.remove(id);
        redirectAttributes.addFlashAttribute("message","delete ok");
        return "redirect:/blog";
    }
    @GetMapping("/views/{id}")
    public String views(@PathVariable int id,Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "views";
    }
}
