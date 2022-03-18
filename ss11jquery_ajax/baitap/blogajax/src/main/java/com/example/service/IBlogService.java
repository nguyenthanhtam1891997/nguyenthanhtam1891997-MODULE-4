package com.example.service;


import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Page<Blog> findAll(Pageable pageable);

    void save(Blog blog);

    Page<Blog> findByNameBlogContaining(String name, Pageable pageable);

    Blog findById(int id);

    void remove(int id);

    Page<Blog> findByCategoryId(int id, Pageable pageable);

    void update(Blog blog);

    List<Blog> findByCategoryId(int id);

    List<Blog> findByNameBlogContaining(String nameBlog);


}
