package com.example.blogspringjpa.service;

import com.example.blogspringjpa.model.BlogTex;
import com.example.blogspringjpa.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<BlogTex> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public BlogTex findById(int id) {
        return blogRepository.findById(id).orElse(new BlogTex());
    }

    @Override
    public void save(BlogTex blogTex) {
        blogRepository.save(blogTex);
    }

    @Override
    public void remove(int id) {
        blogRepository.deleteById(id);
    }
}
