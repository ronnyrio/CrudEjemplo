package com.javatpoint.controller;

import com.javatpoint.model.Author;
import com.javatpoint.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//creating RestController
@RestController
public class AuthorController {
    //autowired the AuthorService class
    @Autowired
    AuthorService authorService;

    //creating a get mapping that retrieves all the authors detail from the database
    @GetMapping("/author")
    private List<Author> getAllAuthor() {
        return authorService.getAllAuthor();
    }

    //creating a get mapping that retrieves the detail of a specific author
    @GetMapping("/author/{id}")
    private Author getAuthor(@PathVariable("id") int id) {
        return authorService.getAuthorById(id);
    }

    //creating a delete mapping that deletes a specific author
    @DeleteMapping("/author/{id}")
    private void deleteAuthor(@PathVariable("id") int id) {
        authorService.delete(id);
    }

    //creating post mapping that post the author detail in the database
    @PostMapping("/author")
    private int saveAuthor(@RequestBody Author author) {
        authorService.saveOrUpdate(author);
        return author.getId();
    }
}
