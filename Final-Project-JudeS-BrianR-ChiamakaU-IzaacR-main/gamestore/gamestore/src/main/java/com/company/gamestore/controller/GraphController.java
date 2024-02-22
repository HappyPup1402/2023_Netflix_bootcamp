package com.company.gamestore.controller;

import com.company.gamestore.model.Console;
import com.company.gamestore.model.Game;
import com.company.gamestore.repository.ConsoleRepository;
import com.company.gamestore.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphController {
    @Autowired
    GameRepository gameRepository;

    @Autowired
    ConsoleRepository consoleRepository;

    @QueryMapping
    public List<Game> findAllGames() {
        return gameRepository.findAll();
    }

    @QueryMapping
    public Game findGameById(@Argument Integer id) {
        return gameRepository.findById(id).get();
    }

    @QueryMapping
    public List<Game> findGameByTitle(@Argument String title) {
        return gameRepository.findByTitle(title);
    }

    @QueryMapping
    public List<Game> findGameByEsrbRating(@Argument String esrbRating) {
        return gameRepository.findByEsrbRating(esrbRating);
    }

    @QueryMapping
    public List<Game> findGameByStudio(@Argument String studio) {
        return gameRepository.findByStudio(studio);
    }

    @QueryMapping
    public Console findConsoleById(@Argument Integer id) {
        return consoleRepository.findById(id).get();
    }

    @QueryMapping
    public List<Console> findAllConsoles() {
        return consoleRepository.findAll();
    }

    @QueryMapping
    public List<Console> findConsoleByManufacturer(@Argument String manufacturer) {
        return consoleRepository.findByManufacturer(manufacturer);
    }
}
