package com.company.gamestore.controller;

import com.company.gamestore.model.Console;
import com.company.gamestore.model.Game;
import com.company.gamestore.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
public class GameController {

    @Autowired
    ServiceLayer serviceLayer;

    @PostMapping("/games")
    @ResponseStatus(HttpStatus.CREATED)
    public Game createGame(@RequestBody Game game) {
        return serviceLayer.saveGame(game);
    }

    @GetMapping("/games/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Game getGameById(@PathVariable int id) {
        return serviceLayer.findGameById(id);
    }

    @GetMapping("/games")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getAllGames() {
        return serviceLayer.findAllGames();
    }

    @PutMapping("/games")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGame(@RequestBody @Valid Game game) {
        serviceLayer.saveGame(game);
    }

    @DeleteMapping("/games/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable int id) {
        serviceLayer.deleteGameById(id);
    }
/*
    List<Game> findByStudio(String studio);
    List<Game> findByEsrbRating(String esrbRating);
    List<Game> findByTitle(String title)
 */

    @GetMapping("games/studio/{studio}")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getGamesByStudio(@PathVariable String studio) {
        return serviceLayer.findByStudio(studio);
    }

    @GetMapping("games/esrb/{esrb}")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getGamesByEsrbRating(@PathVariable String esrb) {
        return serviceLayer.findByEsrbRating(esrb);
    }

    @GetMapping("games/title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getGamesByTitle(@PathVariable String title) {
        return serviceLayer.findByTitle(title);
    }

}
