package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {
Page<Blog> findByNameBlogContaining(String name, Pageable pageable);
Page<Blog> findByCategoryId(int id,Pageable pageable);

}
