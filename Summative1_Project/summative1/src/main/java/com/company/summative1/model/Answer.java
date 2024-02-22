package com.company.summative1.model;

public class Answer {
    private int id;
    private String question;
    private String answer;

    public Answer(){}

    public Answer(int id, String question, String answer){
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
