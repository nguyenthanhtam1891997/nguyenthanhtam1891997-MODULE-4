package com.example.blog.service;

import com.example.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    Page<Category> findAll(Pageable pageable);

    void save(Category category);

    Page<Category> findByNameCategoryContaining(String name, Pageable pageable);

    Category findById(int id);

    void remove(int id);
    void  update(Category category,int id);
}
