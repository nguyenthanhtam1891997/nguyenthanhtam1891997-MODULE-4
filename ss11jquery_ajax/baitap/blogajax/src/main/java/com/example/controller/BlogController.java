package com.example.controller;


import com.example.model.Blog;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String index(Model model,
                        @PageableDefault(value = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        model.addAttribute("blogList", blogService.findAll(pageable));
        return "list";
    }

    @GetMapping("/creat")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList",categoryService.findAll());
        return "creat";
    }

    @PostMapping("/save")
    public String saveBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
//        blog.setDayValue(new Date(System.currentTimeMillis()));
        blog.setDayValue(String.valueOf(java.time.LocalDate.now()));
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "create ok");
        return "redirect:/blog";
    }

    @GetMapping("/delete/{id}")
    public String removeBlog(@PathVariable int id, RedirectAttributes redirectAttributes) {
        blogService.remove(id);
        redirectAttributes.addFlashAttribute("message", "delete ok");
        return "redirect:/blog";
    }

    @GetMapping("/edit/{id}")
    public String editBlog(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String updateBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "update ok");
        return "redirect:/blog";
    }

    @GetMapping("/view/{id}")
    public String viewBlog(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "view";
    }

}
