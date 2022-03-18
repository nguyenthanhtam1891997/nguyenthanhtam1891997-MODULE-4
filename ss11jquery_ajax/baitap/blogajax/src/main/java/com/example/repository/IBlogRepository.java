package com.example.repository;


import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {
Page<Blog> findByNameBlogContaining(String name, Pageable pageable);
Page<Blog> findByCategoryId(int id,Pageable pageable);
List<Blog> findByCategoryId(int id);
List<Blog> findByNameBlogContaining(String nameBlog);

}
