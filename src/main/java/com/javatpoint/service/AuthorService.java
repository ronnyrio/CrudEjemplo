package com.javatpoint.service;

import com.javatpoint.model.Author;
import com.javatpoint.repository.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public List<Author> getAllAuthor() {
        List<Author> authors = new ArrayList<>();
        authorRepository.findAll().forEach(author -> authors.add(author));
        log.info("pasé por getAllAuthor");
        return authors;
    }

    public Author getAuthorById(int id) {
        log.info("pasé por getAuthorById");
        return authorRepository.findById(id).get();
    }

    public void saveOrUpdate(Author author) {
        log.info("pasé por saveOrUpdate");
        authorRepository.save(author);
    }

    public void delete(int id) {
        log.info("pasé por delete");
        authorRepository.deleteById(id);
    }
}
