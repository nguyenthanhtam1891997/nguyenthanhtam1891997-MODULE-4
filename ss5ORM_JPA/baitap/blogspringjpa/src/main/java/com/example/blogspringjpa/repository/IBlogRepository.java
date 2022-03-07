package com.example.blogspringjpa.repository;

import com.example.blogspringjpa.model.BlogTex;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<BlogTex,Integer> {
}
