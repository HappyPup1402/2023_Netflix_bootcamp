package com.company.bookstore.controller;

import com.company.bookstore.model.Book;
import com.company.bookstore.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookRepository bookRepository;

    private ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {

    }

    // Testing POST "/book"
    @Test
    public void shouldCreateBook() throws Exception{
        Book book = new Book();
        book.setIsbn("101-222-3333");
        book.setPrice(new BigDecimal("24.99"));
        book.setTitle("A New Novel");

        String inputJson = mapper.writeValueAsString(book);

        mockMvc.perform(post("/book")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
                )
                    .andDo(print())
                    .andExpect(status().isCreated());
    }

    // Testing GET "/book/{id}"
    @Test
    public void shouldGetBookById() throws Exception{
        Book book = new Book();
        book.setIsbn("101-222-3333");
        book.setPrice(new BigDecimal("24.99"));
        book.setTitle("A New Novel");
        book.setId(1);

        bookRepository.save(book);

        mockMvc.perform(get("/book/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    // Testing GET "/book"
    @Test
    public void shouldGetAllBooks() throws Exception {
        Book book = new Book();
        book.setIsbn("101-222-3333");
        book.setPrice(new BigDecimal("24.99"));
        book.setTitle("A New Novel");
        bookRepository.save(book);

        Book book1 = new Book();
        book1.setIsbn("232-414-3137");
        book1.setPrice(new BigDecimal("12.99"));
        book1.setTitle("An Old Novel");
        bookRepository.save(book1);

        mockMvc.perform(get("/book"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    // Testing PUT "/book"
    @Test
    public void shouldUpdateBook() throws Exception {
        Book book = new Book();
        book.setIsbn("101-222-3333");
        book.setPrice(new BigDecimal("24.99"));
        book.setTitle("A New Novel");

        String inputJson = mapper.writeValueAsString(book);

        mockMvc.perform(put("/book")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    // Testing DELETE "/book/{id}"
    @Test
    public void shouldDeleteBookById() throws Exception {
        Book book = new Book();
        book.setIsbn("101-222-3333");
        book.setPrice(new BigDecimal("24.99"));
        book.setTitle("A New Novel");
        book.setPublishedDate(LocalDate.of(2020, 1, 8));
        book.setId(1);
        bookRepository.save(book);

        mockMvc.perform(delete("/book/1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    // Testing GET "/book/author/{authorId}"
    @Test
    public void shouldGetBooksByAuthorId() throws Exception {
        Book book = new Book();
        book.setIsbn("101-222-3333");
        book.setPrice(new BigDecimal("24.99"));
        book.setTitle("A New Novel");
        book.setPublishedDate(LocalDate.of(2020, 1, 8));
        bookRepository.save(book);

        Book book1 = new Book();
        book1.setIsbn("232-414-3137");
        book1.setPrice(new BigDecimal("12.99"));
        book1.setTitle("An Old Novel");
        book1.setPublishedDate(LocalDate.of(2042, 1, 9));
        bookRepository.save(book1);

        mockMvc.perform(get("/book/author/2"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}