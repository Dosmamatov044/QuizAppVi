package com.data;

import com.core.IBaseCallback;
import com.model.Question;
import com.model.QuizResponse;

import java.util.List;

public  interface IQuizApiClient {




    void getQuestions(int amount, Integer category, String difficulty, QuestionCallback callback);



    interface QuestionCallback extends IBaseCallback <List<Question>> {





    void onSuccess(List<Question>questions);
    void onFailure(Exception e);


}


}
