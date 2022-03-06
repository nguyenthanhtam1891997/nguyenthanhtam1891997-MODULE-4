package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "nasa")
public class NaSaImg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int points;
    private String name;
    private String comment;
    @Column(name = "like_img")
    private int like;

    public NaSaImg() {
    }

    public NaSaImg(int points, String name, String comment, int like) {

        this.points = points;
        this.name = name;
        this.comment = comment;
        this.like = like;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    @Override
    public String toString() {
        return "NaSaImg{" +
                "id=" + id +
                ", points=" + points +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                ", like=" + like +
                '}';
    }
}
