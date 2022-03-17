package com.example.blog.controller;

import com.example.blog.dto.BlogDto;
import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class ApiBlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;


    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categoryList = categoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/blog")
    public ResponseEntity<List<Blog>> getAllBlog() {
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<List<Blog>> getBlogByIdCategory(@PathVariable int id) {
        List<Blog> blogList = blogService.findByCategoryId(id);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @PostMapping("/creat/category")
    public ResponseEntity addCategory(@RequestBody Category category) {
        categoryService.save(category);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping(value = "/creat/blog", produces = "application/json")
    public ResponseEntity addBlog(@RequestBody BlogDto blogDto) {
        if (categoryService.findById(blogDto.getCategory()) == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            Blog blog = new Blog();
            BeanUtils.copyProperties(blogDto, blog);
            blog.setCategory(categoryService.findById(blogDto.getCategory()));
//            blog.getCategory().setId(blogDto.getCategory());
            blog.setDayValue(java.time.LocalDate.now());
            blogService.save(blog);
            return new ResponseEntity(HttpStatus.OK);
        }


    }


    @PutMapping("/category/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category category) {
        Category currentCategory = categoryService.findById(id);
        if (currentCategory == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            BeanUtils.copyProperties(category, currentCategory);
            currentCategory.setBlogs(category.getBlogs());
            categoryService.save(currentCategory);
            return new ResponseEntity<>(currentCategory, HttpStatus.OK);
        }
    }

    //    @PatchMapping("/category/{id}")
//    public ResponseEntity<Category> updateCategory2(@PathVariable int id,@RequestBody Category category){
//        Category currentCategory = categoryService.findById(id);
//        if (currentCategory == null){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }else {
//            BeanUtils.copyProperties(category,currentCategory);
//            categoryService.save(category);
//            return new ResponseEntity<>(category,HttpStatus.OK);
//        }
//    }
    @DeleteMapping("/category/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable int id) {
        if (categoryService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            categoryService.remove(id);
            return new ResponseEntity<>(categoryService.findById(id), HttpStatus.NO_CONTENT);
        }
    }
    @DeleteMapping("/blog/{id}")
    public ResponseEntity deleteBlog(@PathVariable int id){
        if (blogService.findById(id)==null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }else {
            blogService.remove(id);
            return new ResponseEntity(HttpStatus.OK);
        }
    }
}
