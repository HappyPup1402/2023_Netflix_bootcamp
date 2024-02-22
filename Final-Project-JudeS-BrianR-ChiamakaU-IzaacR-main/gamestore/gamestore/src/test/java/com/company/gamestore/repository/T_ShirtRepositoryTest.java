package com.company.gamestore.repository;

import com.company.gamestore.model.Game;
import com.company.gamestore.model.T_Shirt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class T_ShirtRepositoryTest {
    @Autowired
    T_ShirtRepository t_shirtRepository;

    @BeforeEach
    void setUp(){
        t_shirtRepository.deleteAll();
    }

    @Test
    public void createTShirtTest(){
        T_Shirt TShirt = new T_Shirt();
        TShirt.setSize("XL");
        TShirt.setColor("Black");
        TShirt.setDescription("Black tshirt with naruto on it");
        TShirt.setPrice(new BigDecimal(30.00));
        TShirt.setQuantity(2);

        TShirt = t_shirtRepository.save(TShirt);

        Optional<T_Shirt> newTshirt = t_shirtRepository.findById(TShirt.getId());
        assertTrue(newTshirt.isPresent());
    }

    @Test
    public void getTShirtByIdTest(){
        T_Shirt TShirt = new T_Shirt();
        TShirt.setSize("XL");
        TShirt.setColor("Black");
        TShirt.setDescription("Black tshirt with naruto on it");
        TShirt.setPrice(new BigDecimal(30.00));
        TShirt.setQuantity(2);

        TShirt = t_shirtRepository.save(TShirt);

        Optional<T_Shirt> retrievedTShirt = t_shirtRepository.findById(TShirt.getId());

        assertNotNull(retrievedTShirt);
    }

    @Test
    public void getAllTShirtsTest(){
        T_Shirt TShirt = new T_Shirt();
        TShirt.setSize("XL");
        TShirt.setColor("Black");
        TShirt.setDescription("Black tshirt with naruto on it");
        TShirt.setPrice(new BigDecimal(30.00));
        TShirt.setQuantity(2);

        TShirt = t_shirtRepository.save(TShirt);

        T_Shirt TShirt2 = new T_Shirt();
        TShirt2.setSize("S");
        TShirt2.setColor("White");
        TShirt2.setDescription("White T shirt with isabelle and the villagers on it");
        TShirt2.setPrice(new BigDecimal(30.00));
        TShirt2.setQuantity(4);

        TShirt2 = t_shirtRepository.save(TShirt2);

        List<T_Shirt> allTShirts = t_shirtRepository.findAll();
        assertEquals(allTShirts.size(), 2);
    }

    @Test
    public void updateTShirtTest(){
        T_Shirt TShirt = new T_Shirt();
        TShirt.setSize("XL");
        TShirt.setColor("Black");
        TShirt.setDescription("Black tshirt with naruto on it");
        TShirt.setPrice(new BigDecimal(30.00));
        TShirt.setQuantity(2);

        TShirt = t_shirtRepository.save(TShirt);

        TShirt.setQuantity(8);

        t_shirtRepository.save(TShirt);

        assertEquals(TShirt.getQuantity(), 8);
    }

    @Test
    public void deleteTShirtTest(){
        T_Shirt TShirt = new T_Shirt();
        TShirt.setSize("XL");
        TShirt.setColor("Black");
        TShirt.setDescription("Black tshirt with naruto on it");
        TShirt.setPrice(new BigDecimal(30.00));
        TShirt.setQuantity(2);

        TShirt = t_shirtRepository.save(TShirt);

        t_shirtRepository.delete(TShirt);

        T_Shirt deletedTSHirt = t_shirtRepository.findById(TShirt.getId()).orElse(null);
        assertNull(deletedTSHirt);
    }

    @Test
    public void getTShirtBySizeTest(){
        T_Shirt TShirt = new T_Shirt();
        TShirt.setSize("XL");
        TShirt.setColor("Black");
        TShirt.setDescription("Black tshirt with naruto on it");
        TShirt.setPrice(new BigDecimal(30.00));
        TShirt.setQuantity(2);

        TShirt = t_shirtRepository.save(TShirt);

        List<T_Shirt> allTShirtsBySize = t_shirtRepository.findBySize("XL");
        assertEquals(allTShirtsBySize.size(), 1);
    }

    @Test
    public void getTShirtByColorTest(){
        T_Shirt TShirt = new T_Shirt();
        TShirt.setSize("XL");
        TShirt.setColor("Black");
        TShirt.setDescription("Black tshirt with naruto on it");
        TShirt.setPrice(new BigDecimal(30.00));
        TShirt.setQuantity(2);

        TShirt = t_shirtRepository.save(TShirt);

        List<T_Shirt> allTShirtsByColor = t_shirtRepository.findByColor("Black");
        assertEquals(allTShirtsByColor.size(), 1);
    }
}