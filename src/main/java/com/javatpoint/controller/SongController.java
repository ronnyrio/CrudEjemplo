package com.javatpoint.controller;

import com.javatpoint.model.Song;
import com.javatpoint.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

//creating RestController
@RestController
public class SongController {
    //autowired the SongService class
    @Autowired
    SongService songService;

    //creating a get mapping that retrieves all the songs detail from the database
    @GetMapping("/song")
    private List<Song> getAllSong() {
        return songService.getAllSong();
    }

    //creating a get mapping that retrieves the detail of a specific song
    @GetMapping("/song/{id}")
    private Song getSong(@PathVariable("id") int id) {
        return songService.getSongById(id);
    }

    //creating a delete mapping that deletes a specific song
    @DeleteMapping("/song/{id}")
    private void deleteSong(@PathVariable("id") int id) {
        songService.delete(id);
    }

    //creating post mapping that post the song detail in the database
    @PostMapping("/song")
    private UUID saveSong(@RequestBody Song song) {
        songService.saveOrUpdate(song);
        return song.getId();
    }
}
