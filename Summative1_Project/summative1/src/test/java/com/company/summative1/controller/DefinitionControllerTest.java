package com.company.summative1.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(DefinitionController.class)
class DefinitionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getRandomWordTest() throws Exception {
        mockMvc.perform(get("/word"))
                .andExpect(status().isOk());
    }
}