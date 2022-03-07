package com.example.blogspringjpa.model;

import javax.persistence.*;

@Entity
@Table(name = "blog_tex")
public class BlogTex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameBlog;
    private String content;
    private String abbreviate;

    public BlogTex() {
    }

    public BlogTex(String nameBlog, String content, String abbreviate) {
        this.nameBlog = nameBlog;
        this.content = content;
        this.abbreviate = abbreviate;
    }

    public String getAbbreviate() {
        return abbreviate;
    }

    public void setAbbreviate(String abbreviate) {
        this.abbreviate = abbreviate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameBlog() {
        return nameBlog;
    }

    public void setNameBlog(String nameBlog) {
        this.nameBlog = nameBlog;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
