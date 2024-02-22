package com.company.gamestore.controller;

import com.company.gamestore.model.T_Shirt;
import com.company.gamestore.repository.GameRepository;
import com.company.gamestore.repository.T_ShirtRepository;
import com.company.gamestore.service.ServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(T_ShirtController.class)
public class T_ShirtControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    T_ShirtRepository t_shirtRepository;

    @MockBean
    ServiceLayer serviceLayer;

    private final ObjectMapper mapper = new ObjectMapper();

    public void setup() throws Exception{
        t_shirtRepository.deleteAll();
    }

    @Test
    public void shouldCreateTShirt() throws Exception{
        T_Shirt tShirt = new T_Shirt();
        tShirt.setColor("Blue");
        tShirt.setPrice(BigDecimal.valueOf(12.99));
        tShirt.setQuantity(45);
        tShirt.setSize("Medium");
        t_shirtRepository.save(tShirt);

        String inputJson = mapper.writeValueAsString(tShirt);

        mockMvc.perform(post("/tShirts")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldGetTShirtById() throws Exception{
        T_Shirt tShirt = new T_Shirt();
        tShirt.setColor("Blue");
        tShirt.setPrice(BigDecimal.valueOf(12.99));
        tShirt.setQuantity(45);
        tShirt.setSize("Medium");
        t_shirtRepository.save(tShirt);

        mockMvc.perform(get("/tShirts/" + tShirt.getId()))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetAllTShirts() throws Exception{
        T_Shirt tShirt = new T_Shirt();
        tShirt.setColor("Blue");
        tShirt.setPrice(BigDecimal.valueOf(12.99));
        tShirt.setQuantity(45);
        tShirt.setSize("Medium");
        t_shirtRepository.save(tShirt);

        mockMvc.perform(get("/tShirts"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldUpdateTShirt() throws Exception{
        T_Shirt tShirt = new T_Shirt();
        tShirt.setColor("Blue");
        tShirt.setPrice(BigDecimal.valueOf(12.99));
        tShirt.setQuantity(45);
        tShirt.setSize("Medium");
        t_shirtRepository.save(tShirt);

        tShirt.setQuantity(32);
        t_shirtRepository.save(tShirt);

        String inputJson = mapper.writeValueAsString(tShirt);

        mockMvc.perform(put("/tShirts")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldDeleteById() throws Exception{
        T_Shirt tShirt = new T_Shirt();
        tShirt.setColor("Blue");
        tShirt.setPrice(BigDecimal.valueOf(12.99));
        tShirt.setQuantity(45);
        tShirt.setSize("Medium");
        t_shirtRepository.save(tShirt);

        mockMvc.perform(delete("/tShirts/" + tShirt.getId()))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldGetTShirtByColor() throws Exception{
        T_Shirt tShirt = new T_Shirt();
        tShirt.setColor("Blue");
        tShirt.setPrice(BigDecimal.valueOf(12.99));
        tShirt.setQuantity(45);
        tShirt.setSize("Medium");
        t_shirtRepository.save(tShirt);

        mockMvc.perform(get("/tShirts/color/" + tShirt.getColor()))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetTShirtBySize() throws Exception{
        T_Shirt tShirt = new T_Shirt();
        tShirt.setColor("Blue");
        tShirt.setPrice(BigDecimal.valueOf(12.99));
        tShirt.setQuantity(45);
        tShirt.setSize("Medium");
        t_shirtRepository.save(tShirt);

        mockMvc.perform(get("/tShirts/size/" + tShirt.getSize()))
                .andDo(print())
                .andExpect(status().isOk());
    }
}