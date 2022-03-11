package com.example.music.service;


import com.example.music.model.Music;
import com.example.music.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService{
    @Autowired
    private IMusicRepository musicRepository;
    @Override
    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public void save(Music music) {
        musicRepository.save(music);
    }

    @Override
    public Music findById(int id) {
        return musicRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Music music) {
        musicRepository.save(music);
    }

    @Override
    public void remove(int id) {
        musicRepository.deleteById(id);
    }
}
