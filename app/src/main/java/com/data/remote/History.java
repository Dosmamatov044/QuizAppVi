package com.data.remote;



import java.util.Date;

public class History {

    private int id;

    private  String category;
private String difficulty;
private  int correctAnswer;
private int amount;
private Date createAt;

    public History(int id, String category, String difficulty, int correctAnswer, int amount, Date createAt) {
        this.id=id;
        this.category = category;
        this.difficulty = difficulty;
        this.correctAnswer = correctAnswer;
        this.amount = amount;
        this.createAt = createAt;
    }




    public int getId() {
       return id;
   }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
