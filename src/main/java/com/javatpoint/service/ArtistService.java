package com.javatpoint.service;


import com.javatpoint.model.Artist;
import com.javatpoint.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ArtistService {

    @Autowired
    ArtistRepository artistRepository;

    public List<Artist> getAllArtist() {
        List<Artist> artists = new ArrayList<>();
        artistRepository.findAll().forEach(artist -> artists.add(artist));
        return artists;
    }

    public Artist getArtistById(int id) {
        return artistRepository.findById(id).get();
    }

    public void saveOrUpdate(Artist artist) {
        artistRepository.save(artist);
    }

    public void delete(int id) {
        artistRepository.deleteById(id);
    }
}