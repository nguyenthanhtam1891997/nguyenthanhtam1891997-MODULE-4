package com.example.music.dto;

import javax.validation.constraints.*;

public class MusicDto {

    private Integer id;


    //    @NotBlank(message = "khong duoc de trong")
    @NotEmpty(message = "không đươc để trống")
    @Size(max = 80)
    @Pattern(regexp = "^[\\w\\s[^@:;.,=+...-]]*$", message = "khong chua cac ký tự ddwatj biet")
    private String nameMusic;


    //    @NotBlank(message = "khong duoc de trong")
    @NotEmpty(message = "không đươc để trống")
    @Size(max = 80)

    @Pattern(regexp = "^[\\w\\s[^@:;.,=+...-]]*$", message = "khong chua cac ký tự ddwatj biet")
    private String nameSinger;


    //    @NotBlank(message = "khong duoc de trong")
    @NotEmpty(message = "không đươc để trống")
    @Size(max = 80)

    @Pattern(regexp = "^[\\w\\s[^@]]*$", message = "khong chua cac ký tự ddwatj biet")
    private String linkMusic;

    public MusicDto() {
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
}
