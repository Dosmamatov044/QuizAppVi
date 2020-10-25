package com.model;

import com.Helper.EType;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public  class Question {

   @SerializedName ("category")
    private String category;

    private String difficulty;

    private String question;
    @SerializedName("correct_answer")
    private String correctAnswer;
    @SerializedName("incorrect_answers")
    private List<String> incorrect;


    private List<String> answers;
    private Integer selectAnswerPosition;
@SerializedName("isAnswered")
    private boolean isAnswered;

    private EType type;

    public Question(String category, String difficulty, String question, String correctAnswer, List<String> incorrect, List<String> answers, Integer selectAnswerPosition, boolean isAnswered, EType type) {
        this.category = category;
        this.difficulty = difficulty;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.incorrect = incorrect;
        this.answers = answers;
        this.selectAnswerPosition = selectAnswerPosition;
        this.isAnswered = isAnswered;
        this.type = type;
    }





    public boolean isAnswered() {
        return isAnswered;
    }

    public void setAnswered(boolean answered) {
        isAnswered = answered;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public Integer getSelectAnswerPosition() {
        return selectAnswerPosition;
    }

    public void setSelectAnswerPosition(Integer selectAnswerPosition) {
        this.selectAnswerPosition = selectAnswerPosition;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public EType getType() {
        return type;
    }

    public void setType(EType type) {
        this.type = type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public List<String> getIncorrect() {
        return incorrect;
    }

    public void setIncorrect(List<String> incorrect) {
        this.incorrect = incorrect;
    }
}
