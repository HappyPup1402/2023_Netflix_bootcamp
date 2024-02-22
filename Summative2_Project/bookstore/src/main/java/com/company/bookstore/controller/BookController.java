package com.company.bookstore.controller;

import com.company.bookstore.model.Book;
import com.company.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.sql.rowset.serial.SerialException;
import java.rmi.ServerException;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    BookRepository repo;

    @PostMapping("/book")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book newBook = repo.save(book);

        if (newBook == null) {
            return null;
        }
        else {
            return new ResponseEntity<>(newBook, HttpStatus.CREATED);
        }
    }

    @GetMapping("/book/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBookById(@PathVariable int id) {
        Optional<Book> returnVal = repo.findById(id);

        if (returnVal.isPresent()) {
            return returnVal.get();
        }
        else {
            return null;
        }
    }

    @GetMapping("/book")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
    }

    @PutMapping("/book")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBook(@RequestBody Book book) {
        repo.save(book);
    }

    @DeleteMapping("/book/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBookById(@PathVariable int id) {
        repo.deleteById(id);
    }

    @GetMapping("/book/author/{authorId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Book>> getBookByAuthorId(@PathVariable int authorId) {
        return new ResponseEntity<>(repo.findBookByAuthorId(authorId), HttpStatus.OK);
    }
}
