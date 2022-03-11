package com.example.music.model;

import javax.persistence.*;

@Entity
@Table(name = "MUSIC")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
        private String nameMusic;
        private String nameSinger;
        private String linkMusic;

    public Music() {
    }

    public Music(String nameMusic, String nameSinger, String linkMusic) {
        this.nameMusic = nameMusic;
        this.nameSinger = nameSinger;
        this.linkMusic = linkMusic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameMusic() {
        return nameMusic;
    }

    public void setNameMusic(String nameMusic) {
        this.nameMusic = nameMusic;
    }

    public String getNameSinger() {
        return nameSinger;
    }

    public void setNameSinger(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    public String getLinkMusic() {
        return linkMusic;
    }

    public void setLinkMusic(String linkMusic) {
        this.linkMusic = linkMusic;
    }

    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", nameMusic='" + nameMusic + '\'' +
                ", nameSinger='" + nameSinger + '\'' +
                ", linkMusic='" + linkMusic + '\'' +
                '}';
    }
}
