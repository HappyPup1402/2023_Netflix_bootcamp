package com.company.bookstore.repository;

import com.company.bookstore.model.Author;
import com.company.bookstore.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthorRepositoryTest {
    @Autowired
    AuthorRepository repo;


    @BeforeEach
    void setUp(){
        repo.deleteAll();
    }

    @Test
    public void addAuthorTest(){
        Author author = new Author();
        author.setFirstName("Chiamaka");
        author.setLastName("Udechukwu");
        author.setStreet("Fenimore");
        author.setCity("Brooklyn");
        author.setState("NY");
        author.setPostalCode("11225");
        author.setPhone("4155703748");
        author.setEmail("chaiamaka@gmailc.om");

        author = repo.save(author);

        Optional<Author> newAuthor = repo.findById(author.getId());
        assertEquals(newAuthor.get(), author);
    }

    @Test
    public void getAuthorByIdTest(){
        Author author = new Author();
        author.setFirstName("Chiamaka");
        author.setLastName("Udechukwu");
        author.setStreet("Fenimore");
        author.setCity("Brooklyn");
        author.setState("NY");
        author.setPostalCode("11225");
        author.setPhone("4155703748");
        author.setEmail("chaiamaka@gmailc.om");

        author = repo.save(author);
        Optional<Author> retrievedAuthor = repo.findById(author.getId());

        assertTrue(retrievedAuthor.isPresent());
        assertEquals(retrievedAuthor.get(), author);
    }

    @Test
    public void getAllAuthorsTest(){
        Author author = new Author();
        author.setFirstName("Chiamaka");
        author.setLastName("Udechukwu");
        author.setStreet("Fenimore");
        author.setCity("Brooklyn");
        author.setState("NY");
        author.setPostalCode("11225");
        author.setPhone("4155703748");
        author.setEmail("chaiamaka@gmailc.om");
        author = repo.save(author);

        Author author1 = new Author();
        author1.setFirstName("Chiamaka");
        author1.setLastName("Udechukwu");
        author1.setStreet("Fenimore");
        author1.setCity("Brooklyn");
        author1.setState("NY");
        author1.setPostalCode("11225");
        author1.setPhone("4155703748");
        author1.setEmail("chaiamaka@gmailc.om");
        author1 = repo.save(author1);

        List<Author> allAuthors = repo.findAll();
        assertEquals(allAuthors.size(), 2);
    }

    @Test
    public void updateAuthorTest(){
        Author author = new Author();
        author.setFirstName("Chiamaka");
        author.setLastName("Udechukwu");
        author.setStreet("Fenimore");
        author.setCity("Brooklyn");
        author.setState("NY");
        author.setPostalCode("11225");
        author.setPhone("4155703748");
        author.setEmail("chaiamaka@gmailc.om");
        author = repo.save(author);

        author.setCity("San francisco");
        repo.save(author);

        Optional<Author> newAuthor = repo.findById(author.getId());
        assertEquals(newAuthor.get(), author);
    }

    @Test
    public void deleteAuthorTest(){
        Author author = new Author();
        author.setFirstName("Chiamaka");
        author.setLastName("Udechukwu");
        author.setStreet("Fenimore");
        author.setCity("Brooklyn");
        author.setState("NY");
        author.setPostalCode("11225");
        author.setPhone("4155703748");
        author.setEmail("chaiamaka@gmailc.om");

        author = repo.save(author);

        repo.delete(author);

        Author deletedAuthor = repo.findById(author.getId()).orElse(null);
        assertNull(deletedAuthor);
    }

}