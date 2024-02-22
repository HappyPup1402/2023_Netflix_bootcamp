package com.company.gamestore.repository;



import com.company.gamestore.model.Console;
import com.company.gamestore.model.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GameRepositoryTest {
    @Autowired
    GameRepository gameRepository;

    @BeforeEach
    void setUp(){
        gameRepository.deleteAll();
    }

    @Test
    public void createGameTest(){
        Game game = new Game();
        game.setTitle("God of war");
        game.setEsrbRating("Pegi18");
        game.setDescription("Former greek god of war tries his best to raise and protect his son, however, his son wants to know who he truly is.");
        game.setPrice(new BigDecimal(60.00));
        game.setStudio("Santa Monica Studio");
        game.setQuantity(1);

        game = gameRepository.save(game);

        Optional<Game> savedGameOptional = gameRepository.findById(game.getId());
        assertTrue(savedGameOptional.isPresent());
    }

    @Test
    public void getGameByIdTest(){
        Game game = new Game();
        game.setTitle("God of war");
        game.setEsrbRating("Pegi 18");
        game.setDescription("Former greek god of war tries his best to raise and protect his son, however, his son wants to know who he truly is.");
        game.setPrice(new BigDecimal(60.00));
        game.setStudio("Santa Monica Studio");
        game.setQuantity(1);

        game = gameRepository.save(game);

        Optional<Game> retrievedGame = gameRepository.findById(game.getId());

        assertNotNull(retrievedGame);
    }

    @Test
    public void getAllGamesTest(){
        Game game = new Game();
        game.setTitle("God of war");
        game.setEsrbRating("Pegi 18");
        game.setDescription("Former greek god of war tries his best to raise and protect his son, however, his son wants to know who he truly is.");
        game.setPrice(new BigDecimal(60.00));
        game.setStudio("Santa Monica Studio");
        game.setQuantity(1);

        game = gameRepository.save(game);

        Game game2 = new Game();
        game2.setTitle("castle crashers");
        game2.setEsrbRating("Pegi 18");
        game2.setDescription("A party game where you play as knights with magic power to save princess");
        game2.setPrice(new BigDecimal(30.00));
        game2.setStudio("The Behemoth");
        game2.setQuantity(2);

        game2 = gameRepository.save(game2);

        List<Game> allGames = gameRepository.findAll();
        assertEquals(allGames.size(), 2);
    }

    @Test
    public void updateGameTest(){
        Game game = new Game();
        game.setTitle("God of war");
        game.setEsrbRating("Pegi 18");
        game.setDescription("Former greek god of war tries his best to raise and protect his son, however, his son wants to know who he truly is.");
        game.setPrice(new BigDecimal(60.00));
        game.setStudio("Santa Monica Studio");
        game.setQuantity(1);

        game = gameRepository.save(game);

        game.setPrice(new BigDecimal(50.00));

        gameRepository.save(game);

        assertEquals(new BigDecimal(50.00), game.getPrice());
    }

    @Test
    public void deleteGameTest(){
        Game game = new Game();
        game.setTitle("God of war");
        game.setEsrbRating("Pegi 18");
        game.setDescription("Former greek god of war tries his best to raise and protect his son, however, his son wants to know who he truly is.");
        game.setPrice(new BigDecimal(60.00));
        game.setStudio("Santa Monica Studio");
        game.setQuantity(1);

        game = gameRepository.save(game);

        gameRepository.delete(game);

        Game deletedGame = gameRepository.findById(game.getId()).orElse(null);
        assertNull(deletedGame);
    }

    @Test
    public void getGameByStudioTest(){
        Game game = new Game();
        game.setTitle("God of war");
        game.setEsrbRating("Pegi 18");
        game.setDescription("Former greek god of war tries his best to raise and protect his son, however, his son wants to know who he truly is.");
        game.setPrice(new BigDecimal(60.00));
        game.setStudio("Santa Monica Studio");
        game.setQuantity(1);

        game = gameRepository.save(game);

        List<Game> retrievedGames = gameRepository.findByStudio("Santa Monica Studio");
        assertEquals(retrievedGames.size(), 1);
    }

    @Test
    public void getGameByEsrbTest(){
        Game game = new Game();
        game.setTitle("God of war");
        game.setEsrbRating("Pegi 18");
        game.setDescription("Former greek god of war tries his best to raise and protect his son, however, his son wants to know who he truly is.");
        game.setPrice(new BigDecimal(60.00));
        game.setStudio("Santa Monica Studio");
        game.setQuantity(1);

        game = gameRepository.save(game);

        List<Game> retrievedGames = gameRepository.findByEsrbRating("Pegi 18");
        assertEquals(retrievedGames.size(), 1);
    }

    @Test
    public void getGameByTitleTest(){
        Game game = new Game();
        game.setTitle("God of war");
        game.setEsrbRating("Pegi 18");
        game.setDescription("Former greek god of war tries his best to raise and protect his son, however, his son wants to know who he truly is.");
        game.setPrice(new BigDecimal(60.00));
        game.setStudio("Santa Monica Studio");
        game.setQuantity(1);

        game = gameRepository.save(game);

        List<Game> retrievedGames = gameRepository.findByTitle("God of war");
        assertEquals(retrievedGames.size(), 1);
    }

}