package com.company.summative1.controller;

import com.company.summative1.model.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuoteController {

    private List<Quote> quoteList;

    private int idCounter = 0;

    public QuoteController() {
        quoteList = new ArrayList<>();

        quoteList.add(new Quote(idCounter++, "Walt Disney", "If you can dream it, you can do it."));
        quoteList.add(new Quote(idCounter++, "Michel de Montaigne", "He who is not very strong in memory should not meddle with lying."));
        quoteList.add(new Quote(idCounter++, "Louise Nevelson", "I have made my world and it is a much better world than I ever saw outside."));
        quoteList.add(new Quote(idCounter++, "James Clear", "The most effective form of learning is practice, not planning."));
        quoteList.add(new Quote(idCounter++, "Publilius Syrus", "Depend not on fortune, but on conduct."));
        quoteList.add(new Quote(idCounter++, "Vernon Sanders Law", "Experience is a hard teacher because she gives the test first, the lesson afterwards."));
        quoteList.add(new Quote(idCounter++, "Adam", "Is there any man that needs a reason to protect his own children"));
        quoteList.add(new Quote(idCounter++, "Albert Einstein", "A person who never made a mistake never tried anything new."));
        quoteList.add(new Quote(idCounter++, "Izaac, Brian, Flavia", "Please hire us Netflix."));
        quoteList.add(new Quote(idCounter++, "Muhammad Ali", "Don't count the days, make the days count."));
    }

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Quote getRandomQuote(){
        int randomId = (int)(Math.random() * quoteList.size());

        return quoteList.get(randomId);
    }
}
