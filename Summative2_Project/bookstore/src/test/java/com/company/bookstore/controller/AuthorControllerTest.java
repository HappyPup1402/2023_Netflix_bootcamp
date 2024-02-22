package com.company.bookstore.controller;

import com.company.bookstore.model.Author;
import com.company.bookstore.repository.AuthorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthorControllerTest {

    private ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthorRepository repo;

    @BeforeEach
    public void setUp() {
        repo.deleteAll();
    }

    @Test
    public void addAuthorTest() throws Exception {
        Author author = new Author(1, "Chiamaka", "Udechukwu", "Fenimore",
                "Brooklyn", "New york", "11225", "4155703748",
                "chaiamaka@gmailc.om");

        repo.save(author);

        String inputJson = mapper.writeValueAsString(author);

        mockMvc.perform(post("/author").content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void updateAuthorTest() throws Exception {
        Author author = new Author(1, "Chiamaka", "Udechukwu", "Fenimore",
                "Brooklyn", "New york", "11225", "4155703748",
                "chaiamaka@gmailc.om");

        repo.save(author);

        String inputJson = mapper.writeValueAsString(author);

        author.setPhone("(562)347-4235");

        mockMvc.perform(put("/author/{id}", author.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(inputJson))
                .andExpect(status().isNoContent());
    }

    @Test
    public void deleteAuthorTest() throws Exception {
        Author author = new Author(1, "Chiamaka", "Udechukwu", "Fenimore",
                "Brooklyn", "New york", "11225", "4155703748",
                "chaiamaka@gmailc.om");

        repo.save(author);

        mockMvc.perform(delete("/author/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldGetAuthors() throws Exception {
        Author author = new Author(1, "Chiamaka", "Udechukwu", "Fenimore",
                "Brooklyn", "New york", "11225", "4155703748",
                "chaiamaka@gmailc.om");
        author = repo.save(author);

        Author author1 = new Author(1, "Kenechi", "Udechukwu", "Fenimsjkore",
                "Brooklyn", "New york city", "11225", "4155878703748",
                "kene@gmailc.om");
        author1 = repo.save(author1);

        mockMvc.perform(get("/author"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetAuthorById() throws Exception {
        Author author = new Author(1, "Chiamaka", "Udechukwu", "Fenimore",
                "Brooklyn", "New york", "11225", "4155703748",
                "chaiamaka@gmailc.om");

        repo.save(author);
        mockMvc.perform(get("/author/1"))
                .andExpect(status().isOk());
    }
}
