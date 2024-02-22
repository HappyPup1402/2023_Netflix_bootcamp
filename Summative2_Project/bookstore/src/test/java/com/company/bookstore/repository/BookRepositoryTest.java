package com.company.bookstore.repository;

import com.company.bookstore.model.Author;
import com.company.bookstore.model.Book;
import com.company.bookstore.model.Publisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    PublisherRepository publisherRepository;

    private Book book;
    private Author author;
    @BeforeEach
    public void setUp() {
        bookRepository.deleteAll();
        publisherRepository.deleteAll();
        authorRepository.deleteAll();


        author = new Author();
        author.setFirstName("Bob");
        author.setLastName("Thumb");
        author.setStreet("Colima");
        author.setCity("Whittier");
        author.setState("CA");
        author.setPostalCode("90650");
        author.setPhone("973-274-0903");
        author.setEmail("hi@gmail.com");
        author = authorRepository.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("Izaac Ramirez");
        publisher.setStreet("Elmcroft");
        publisher.setCity("Norwalk");
        publisher.setState("CA");
        publisher.setPostal_code("90650");
        publisher.setPhone("(562)846-8623");
        publisher.setEmail("izaacramirez1402@gmail.com");
        publisher = publisherRepository.save(publisher);

        book = new Book();
        book.setAuthor(author);
        book.setIsbn("101-222-3333");
        book.setPrice(new BigDecimal("24.99"));
        book.setTitle("A New Novel");
        book.setPublishedDate(LocalDate.of(2020, 1, 8));
        book.setPublisher(publisher);

        book = bookRepository.save(book);
    }

    @Test
    public void shouldAddBook() {

        Optional<Book> book1 = bookRepository.findById(book.getId());

        assertEquals(book1.get(), book);
    }

    @Test
    public void shouldGetBookById() {


        Optional<Book> book1 = bookRepository.findById(book.getId());

        assertTrue(book1.isPresent());
        assertEquals(book1.get(), book);
    }

    @Test
    public void shouldGetAllBooks() {

        List<Book> allBooks = bookRepository.findAll();

        assertEquals(allBooks.size(), 1);
    }

    @Test
    public void shouldUpdateBook() {


        book.setTitle("Uncreative Book");
        bookRepository.save(book);

        Optional<Book> book1 = bookRepository.findById(book.getId());

        assertEquals(book1.get(), book);
    }

    @Test
    public void shouldDeleteBookById() {

        bookRepository.delete(book);

        Book deletedBook = bookRepository.findById(book.getId()).orElse(null);

        assertNull(deletedBook);
    }

    @Test
    public void shouldSearchBookByAuthorId() {


        List<Book> bookList = bookRepository.findBookByAuthorId(author.getId());

        assertEquals(bookList.size(), 1);
    }
}