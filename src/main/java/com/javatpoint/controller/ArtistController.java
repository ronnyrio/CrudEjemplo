package com.javatpoint.controller;

import com.javatpoint.model.Artist;
import com.javatpoint.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//creating RestController
@RestController
public class ArtistController {
    //autowired the ArtistService class
    @Autowired
    ArtistService artistService;

    //creating a get mapping that retrieves all the Artists detail from the database
    @GetMapping("/artist")
    private List<Artist> getAllArtist() {
        return artistService.getAllArtist();
    }

    //creating a get mapping that retrieves the detail of a specific Artist
    @GetMapping("/artist/{id}")
    private Artist getArtist(@PathVariable("id") int id) {
        return artistService.getArtistById(id);
    }

    //creating a delete mapping that deletes a specific Artist
    @DeleteMapping("/artist/{id}")
    private void deleteArtist(@PathVariable("id") int id) {
        artistService.delete(id);
    }

    //creating post mapping that post the Artist detail in the database
    @PostMapping("/artist")
    private int saveArtist(@RequestBody Artist artist) {
        artistService.saveOrUpdate(artist);
        return artist.getId();
    }
}
