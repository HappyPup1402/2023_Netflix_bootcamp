package com.company.summative1.controller;

import com.company.summative1.model.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AnswerController {
    private List<Answer> answers;

    private int idCounter = 0;

    public AnswerController() {
        answers = new ArrayList<>();
        answers.add(new Answer(idCounter++,"" ,"No"));
        answers.add(new Answer(idCounter++,"", "Yes"));
        answers.add(new Answer(idCounter++,"", "Ask again"));
        answers.add(new Answer(idCounter++,"", "Without a doubt"));
        answers.add(new Answer(idCounter++,"", "Definitely no"));
        answers.add(new Answer(idCounter++,"", "Maybe"));
    }

    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Answer getRandomAnswer(@RequestBody Answer answer) {
        int randomId = (int)(Math.random() * answers.size());
        for (Answer answers: answers){
            if(randomId == answers.getId()){
                answers.setQuestion(answer.getQuestion());
            }
        }

        return answers.get(randomId);
    }
}
