package com.company.bookstore.controller;

import com.company.bookstore.model.Author;
import com.company.bookstore.model.Publisher;
import com.company.bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {
    @Autowired
    AuthorRepository repo;

    @GetMapping("/author")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Author>> getAuthors() {
        return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
    }


    @GetMapping("/author/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author getAuthorById(@PathVariable int id) {
        Optional<Author> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        }
        else {
            return null;
        }
    }

    @PostMapping("/author")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
        Author newAuthor = repo.save(author);
        if (newAuthor == null) {
            return null;
        }
        else {
            return new ResponseEntity<>(newAuthor, HttpStatus.CREATED);
        }
    }

    @PutMapping("/author")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAuthor(@RequestBody Author author) {
        repo.save(author);
    }

    @DeleteMapping("/author/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable int id) {
        repo.deleteById(id);
    }

}

