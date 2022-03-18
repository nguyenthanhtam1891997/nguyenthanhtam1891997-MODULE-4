package com.example.blog.dto;

import java.time.LocalDate;

public class BlogDto {

    private String nameBlog;
    private String content;
    private String description;
    private LocalDate dayValue;
    private int category;

    public BlogDto() {
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

    public LocalDate getDayValue() {
        return dayValue;
    }

    public void setDayValue(LocalDate dayValue) {
        this.dayValue = dayValue;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
