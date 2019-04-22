package com.jerome_tay.pd3quiz;

public class Question {
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private int answerNr;

    public Question() {
    }

    public Question(String question, String answer1, String answer2, String answer3, String answer4, int answerNr) {
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.answerNr = answerNr;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getanswer1() {
        return answer1;
    }

    public void setanswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getanswer2() {
        return answer2;
    }

    public void setanswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getanswer3() {
        return answer3;
    }

    public void setanswer3(String answer3) {
        this.answer3 = answer3;
    }
    public String getanswer4() {
        return answer4;
    }

    public void setanswer4(String answer4) {
        this.answer4 = answer4;
    }

    public int getAnswerNr() {
        return answerNr;
    }

    public void setAnswerNr(int answerNr) {
        this.answerNr = answerNr;
    }
}

