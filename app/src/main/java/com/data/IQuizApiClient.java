package com.data;

import com.model.Question;
import com.model.QuizResponse;

import java.util.List;

public  interface IQuizApiClient {


  void getQuestions(Integer amount, Integer category, String difficulty, QuestionCallback callback);



    interface QuestionCallback{





    void onSuccess(List<Question>questions);
    void onFailure(Exception e);


}


}
