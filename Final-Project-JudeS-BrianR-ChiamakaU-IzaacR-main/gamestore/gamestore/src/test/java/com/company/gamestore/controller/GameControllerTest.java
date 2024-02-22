package com.company.gamestore.controller;

import com.company.gamestore.model.Game;
import com.company.gamestore.repository.ConsoleRepository;
import com.company.gamestore.repository.GameRepository;
import com.company.gamestore.service.ServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
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

@WebMvcTest(GameController.class)
public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    GameRepository gameRepository;

    @MockBean
    ServiceLayer serviceLayer;

    private final ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void setup() throws Exception{
        gameRepository.deleteAll();
    }

    @Test
    public void shouldCreateGame() throws Exception{
        Game game = new Game();
        game.setPrice(BigDecimal.valueOf(24.99));
        game.setQuantity(13);
        game.setDescription("A game about puzzles");
        game.setTitle("Puzzlemania");
        game.setStudio("E3 Games");
        game.setEsrbRating("E");
        gameRepository.save(game);

        String inputJson = mapper.writeValueAsString(game);

        mockMvc.perform(post("/games")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldGetGameById() throws Exception{
        Game game = new Game();
        game.setPrice(BigDecimal.valueOf(24.99));
        game.setQuantity(13);
        game.setDescription("A game about puzzles");
        game.setTitle("Puzzlemania");
        game.setStudio("E3 Games");
        game.setEsrbRating("E");
        gameRepository.save(game);

        mockMvc.perform(get("/games/" + game.getId()))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetAllGames() throws Exception{
        Game game = new Game();
        game.setPrice(BigDecimal.valueOf(24.99));
        game.setQuantity(13);
        game.setDescription("A game about puzzles");
        game.setTitle("Puzzlemania");
        game.setStudio("E3 Games");
        game.setEsrbRating("E");
        gameRepository.save(game);

        mockMvc.perform(get("/games"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldUpdateGame() throws Exception{
        Game game = new Game();
        game.setPrice(BigDecimal.valueOf(24.99));
        game.setQuantity(13);
        game.setDescription("A game about puzzles");
        game.setTitle("Puzzlemania");
        game.setStudio("E3 Games");
        game.setEsrbRating("E");
        gameRepository.save(game);

        game.setQuantity(10);
        gameRepository.save(game);

        String inputJson = mapper.writeValueAsString(game);

        mockMvc.perform(put("/games")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldDeleteById() throws Exception {
        Game game = new Game();
        game.setPrice(BigDecimal.valueOf(24.99));
        game.setQuantity(13);
        game.setDescription("A game about puzzles");
        game.setTitle("Puzzlemania");
        game.setStudio("E3 Games");
        game.setEsrbRating("E");
        gameRepository.save(game);

        mockMvc.perform(delete("/games/" + game.getId()))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldGetByStudio() throws Exception{
        Game game = new Game();
        game.setPrice(BigDecimal.valueOf(24.99));
        game.setQuantity(13);
        game.setDescription("A game about puzzles");
        game.setTitle("Puzzlemania");
        game.setStudio("E3 Games");
        game.setEsrbRating("E");
        gameRepository.save(game);

        mockMvc.perform(get("/games/studio/" + game.getStudio()))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetByEsrbRating() throws Exception{
        Game game = new Game();
        game.setPrice(BigDecimal.valueOf(24.99));
        game.setQuantity(13);
        game.setDescription("A game about puzzles");
        game.setTitle("Puzzlemania");
        game.setStudio("E3 Games");
        game.setEsrbRating("E");
        gameRepository.save(game);

        mockMvc.perform(get("/games/esrb/" + game.getEsrbRating()))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetByTitle() throws Exception{
        Game game = new Game();
        game.setPrice(BigDecimal.valueOf(24.99));
        game.setQuantity(13);
        game.setDescription("A game about puzzles");
        game.setTitle("Puzzlemania");
        game.setStudio("E3 Games");
        game.setEsrbRating("E");
        gameRepository.save(game);

        mockMvc.perform(get("/games/title/" + game.getTitle()))
                .andDo(print())
                .andExpect(status().isOk());
    }
}