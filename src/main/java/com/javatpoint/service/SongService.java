package com.javatpoint.service;


import com.javatpoint.model.Song;
import com.javatpoint.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongService {

    @Autowired
    SongRepository songRepository;

    public List<Song> getAllSong() {
        List<Song> songs = new ArrayList<>();
        songRepository.findAll().forEach(songs::add);
        return songs;
    }

    public Song getSongById(int id) {
        return songRepository.findById(id).get();
    }

    public void saveOrUpdate(Song song) {
        songRepository.save(song);
    }

    public void delete(int id) {
        songRepository.deleteById(id);
    }
}

