package com.company.bookstore.controller;


import com.company.bookstore.model.Publisher;
import com.company.bookstore.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PublisherController {
    @Autowired
    PublisherRepository repo;

    @PostMapping("/publisher")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Publisher> createPublisher(@RequestBody Publisher publisher){
        Publisher newPublisher = repo.save(publisher);
        if (newPublisher == null) {
            return null;
        }
        else {
            return new ResponseEntity<>(newPublisher, HttpStatus.CREATED);
        }
    }

    @GetMapping("/publisher/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Publisher getPublisherById(@PathVariable int id){
        Optional<Publisher> returnVal = repo.findById(id);

        if (returnVal.isPresent()) {
            return returnVal.get();
        }
        else {
            return null;
        }
    }

    @GetMapping("/publisher")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<Publisher>> getAllPublisher(){
        return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
    }

    @PutMapping ("/publisher")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePublisher(@RequestBody Publisher publisher){
        repo.save(publisher);
    }

    @DeleteMapping("/publisher/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePublisher(@PathVariable int id){
        repo.deleteById(id);
    }
}
