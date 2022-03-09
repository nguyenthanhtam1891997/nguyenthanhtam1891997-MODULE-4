package com.example.blog.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "blog_tex")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nameBlog;
    private String content;
    private String description;
    private Date dayValue;

    public Blog() {
    }

    public Blog(String nameBlog, String content, String description, Date dayValue) {
        this.nameBlog = nameBlog;
        this.content = content;
        this.description = description;
        this.dayValue = dayValue;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDayValue() {
        return dayValue;
    }

    public void setDayValue(Date dayValue) {
        this.dayValue = dayValue;
    }
}
