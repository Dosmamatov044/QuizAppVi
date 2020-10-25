package com.OfflineQuiz;

import androidx.annotation.NonNull;

import java.lang.reflect.Type;

public class Question {
String question;

String optionD;
private  int id;

@NonNull
String [] ArrayAnswer;
String correctAnswers;
Type type;
String color;


    public Question(@org.jetbrains.annotations.NotNull String [] ArrayAnswer, String question, String correctAnswers, Type type) {
        this.question = question;
        this.type=type;

        this.correctAnswers = correctAnswers;
    this.ArrayAnswer=ArrayAnswer;

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }



    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(String correctAnswers) {
        this.correctAnswers = correctAnswers;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String [] getArrayAnswer() {
        return ArrayAnswer;
    }

    public void setArrayAnswer(String[] arrayAnswer) {
        ArrayAnswer = arrayAnswer;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
