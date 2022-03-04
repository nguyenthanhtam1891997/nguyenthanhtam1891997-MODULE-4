package com.example.repository;

import com.example.model.Music;

import java.util.List;

public interface IMusicRepository {
List<Music> findAll();
void save(Music music);
Music findById(long id);
void update(Music music);
void remove(long id);

}
