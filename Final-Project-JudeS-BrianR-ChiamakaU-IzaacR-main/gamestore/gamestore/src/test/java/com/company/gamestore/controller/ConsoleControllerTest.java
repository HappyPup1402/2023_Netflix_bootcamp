package com.company.gamestore.controller;

import com.company.gamestore.model.Console;
import com.company.gamestore.repository.ConsoleRepository;
import com.company.gamestore.service.ServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ConsoleController.class)
public class ConsoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ConsoleRepository consoleRepository;

    @MockBean
    ServiceLayer serviceLayer;

    private final ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void setup() throws Exception{
        consoleRepository.deleteAll();
    }

    @Test
    public void shouldCreateConsole() throws Exception{
        Console console = new Console();
        console.setPrice(BigDecimal.valueOf(223.15));
        console.setManufacturer("Xbox");
        console.setQuantity(15);
        console.setModel("One");
        console.setMemory_amount("256");
        console.setProcessor("i7");
        consoleRepository.save(console);

        String inputJson = mapper.writeValueAsString(console);

        mockMvc.perform(post("/consoles")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldGetConsoleById() throws Exception{
        Console console = new Console();
        console.setPrice(BigDecimal.valueOf(223.15));
        console.setManufacturer("Xbox");
        console.setQuantity(15);
        console.setModel("One");
        console.setMemory_amount("256");
        console.setProcessor("i7");
        consoleRepository.save(console);

        mockMvc.perform(get("/consoles/" + console.getId()))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetAllConsoles() throws Exception{
        Console console = new Console();
        console.setPrice(BigDecimal.valueOf(223.15));
        console.setManufacturer("Xbox");
        console.setQuantity(15);
        console.setModel("One");
        console.setMemory_amount("256");
        console.setProcessor("i7");
        consoleRepository.save(console);

        mockMvc.perform(get("/consoles"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetConsoleByManufacturer() throws Exception {
        Console console = new Console();
        console.setPrice(BigDecimal.valueOf(223.15));
        console.setManufacturer("Xbox");
        console.setQuantity(15);
        console.setModel("One");
        console.setMemory_amount("256");
        console.setProcessor("i7");
        consoleRepository.save(console);

        mockMvc.perform(get("/consoles/manufacturer/Xbox"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteConsoleById() throws Exception{
        Console console = new Console();
        console.setPrice(BigDecimal.valueOf(223.15));
        console.setManufacturer("Xbox");
        console.setQuantity(15);
        console.setModel("One");
        console.setMemory_amount("256");
        console.setProcessor("i7");
        consoleRepository.save(console);

        mockMvc.perform(delete("/consoles/" + console.getId()))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldUpdateConsole() throws Exception{
        Console console = new Console();
        console.setPrice(BigDecimal.valueOf(223.15));
        console.setManufacturer("Xbox");
        console.setQuantity(15);
        console.setModel("One");
        console.setMemory_amount("256");
        console.setProcessor("i7");
        consoleRepository.save(console);

        console.setQuantity(10);
        consoleRepository.save(console);

        String inputJson = mapper.writeValueAsString(console);

        mockMvc.perform(put("/consoles")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}