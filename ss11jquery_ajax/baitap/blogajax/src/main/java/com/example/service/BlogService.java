package com.example.service;


import com.example.model.Blog;
import com.example.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;


    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Page<Blog> findByNameBlogContaining(String name, Pageable pageable) {
        return blogRepository.findByNameBlogContaining(name, pageable);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findByCategoryId(int id, Pageable pageable) {
        return blogRepository.findByCategoryId(id, pageable);
    }

    @Override
    public void update(Blog blog) {

    }

    @Override
    public List<Blog> findByCategoryId(int id) {
        return blogRepository.findByCategoryId(id);
    }

    @Override
    public List<Blog> findByNameBlogContaining(String nameBlog) {
        return blogRepository.findByNameBlogContaining(nameBlog);
    }




}
