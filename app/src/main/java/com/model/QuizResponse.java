package com.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

 public class QuizResponse {
@SerializedName("response_code")
private int response_code;
private List<Question> results;


    public QuizResponse(int response_code, List<Question> results) {
        this.response_code = response_code;
        this.results = results;




    }


    public int getResponse_code() {
        return response_code;
    }

    public void setResponse_code(int response_code) {
        this.response_code = response_code;
    }

    public List<Question> getResults() {
        return results;
    }

    public void setResults(List<Question> results) {
        this.results = results;
    }
}
