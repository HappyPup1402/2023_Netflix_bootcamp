package com.company.summative1.controller;

import com.company.summative1.model.Definition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DefinitionController {

    private List<Definition> words;

    private int idCounter = 0;

    public DefinitionController() {
        words = new ArrayList<>();

        words.add(new Definition(idCounter++, "concern", "something that interests you because it is important"));
        words.add(new Definition(idCounter++, "approach", "move towards"));
        words.add(new Definition(idCounter++, "establish", "to set up or found"));
        words.add(new Definition(idCounter++, "labor", "any piece of work that is undertaken or attempted"));
        words.add(new Definition(idCounter++, "knight", "a person of noble birth trained to arms and chivalry"));
        words.add(new Definition(idCounter++, "inspire", "serve as the inciting cause of"));
        words.add(new Definition(idCounter++, "skill", "an ability that has been acquired by training"));
        words.add(new Definition(idCounter++, "territory", "the geographical area under the jurisdiction of a state"));
        words.add(new Definition(idCounter++, "Luminescence", "Light produced by electric, chemical, or physiological means"));
        words.add(new Definition(idCounter++, "Eloquence", "Ability to beautifully express oneself"));

    }

    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Definition getRandomWord() {
        int randomId = (int)(Math.random() * words.size());

        return words.get(randomId);
    }

}
