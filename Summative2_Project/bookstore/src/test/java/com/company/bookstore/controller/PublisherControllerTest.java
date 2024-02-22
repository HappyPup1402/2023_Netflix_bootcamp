package com.company.bookstore.controller;

import com.company.bookstore.model.Publisher;
import com.company.bookstore.repository.PublisherRepository;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class PublisherControllerTest {
    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PublisherRepository repo;

    @BeforeEach
    public void setUp(){
        repo.deleteAll();
    }

    @Test
    public void createPublisherTest() throws Exception {
        Publisher publisher = new Publisher(1, "Izaac Ramirez", "Elmcroft", "Norwalk",
                "California", "90650", "(562)846-8623", "izaacramirez1402@gmail.com");

        repo.save(publisher);

        String inputJson = mapper.writeValueAsString(publisher);

        mockMvc.perform(post("/publisher").content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void getPublisherByIdTest() throws Exception{
        Publisher publisher = new Publisher(1, "Izaac Ramirez", "Elmcroft", "Norwalk",
                "California", "90650", "(562)846-8623", "izaacramirez1402@gmail.com");

        repo.save(publisher);

        mockMvc.perform(get("/publisher/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void getAllPublishersTest() throws Exception{
        Publisher publisher = new Publisher(1, "Izaac Ramirez", "Elmcroft", "Norwalk",
                "California", "90650", "(562)846-8623", "izaacramirez1402@gmail.com");
        publisher = repo.save(publisher);

        Publisher publisher2 = new Publisher(2, "Edurado Ramirez", "Elmcroft", "Norwalk",
                "California", "90650", "(562)846-8623", "santo757@gmail.com");
        publisher2 = repo.save(publisher2);

        mockMvc.perform(get("/publisher"))
                .andExpect(status().isOk());

    }

    @Test
    public void updatePublisherTest() throws Exception{
        Publisher publisher = new Publisher(1, "Izaac Ramirez", "Elmcroft", "Norwalk",
                "California", "90650", "(562)846-8623", "izaacramirez1402@gmail.com");

        repo.save(publisher);

        String inputJson = mapper.writeValueAsString(publisher);

        publisher.setPhone("(562)347-4235");

        mockMvc.perform(put("/publisher")
                .contentType(MediaType.APPLICATION_JSON)
                .content(inputJson))
                .andExpect(status().isNoContent());

    }

    @Test
    public void deletePublisherTest() throws Exception{
        Publisher publisher = new Publisher(1, "Izaac Ramirez", "Elmcroft", "Norwalk",
                "California", "90650", "(562)846-8623", "izaacramirez1402@gmail.com");

        repo.save(publisher);

        mockMvc.perform(delete("/publisher/{id}", publisher.getId()))
                .andExpect(status().isNoContent());
    }
}