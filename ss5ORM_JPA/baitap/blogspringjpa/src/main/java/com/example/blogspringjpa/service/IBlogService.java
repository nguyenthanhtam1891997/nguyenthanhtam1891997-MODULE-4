package com.example.blogspringjpa.service;

import com.example.blogspringjpa.model.BlogTex;

import java.util.List;

public interface IBlogService {
    List<BlogTex> findAll();

    BlogTex findById(int id);

    void save(BlogTex blogTex);

    void remove(int id);

}
