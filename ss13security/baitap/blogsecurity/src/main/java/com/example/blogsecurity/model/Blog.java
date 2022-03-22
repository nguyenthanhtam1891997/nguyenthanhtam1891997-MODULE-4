package com.example.blogsecurity.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id"
//)


@Entity
@Table(name = "blog_tex")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nameBlog;
    private String content;

    @Column(columnDefinition ="LONGTEXT")
    private String description;
    private String dayValue;

    @JsonBackReference
//    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
//    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)

    private Category category;

    public Blog() {
    }

    public Blog(String nameBlog, String content, String description, String dayValue, Category category) {
        this.nameBlog = nameBlog;
        this.content = content;
        this.description = description;
        this.dayValue = dayValue;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public String getDayValue() {
        return dayValue;
    }

    public void setDayValue(String dayValue) {
        this.dayValue = dayValue;
    }
}
