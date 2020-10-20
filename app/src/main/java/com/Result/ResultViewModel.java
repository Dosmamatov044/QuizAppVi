package com.Result;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.QuizApp;
import com.model.QuestionResult;


public class ResultViewModel extends ViewModel {

    public MutableLiveData<QuestionResult> quizResultMutableLiveData = new MutableLiveData<>();

    public void getResult(int id){
        quizResultMutableLiveData.setValue(QuizApp.quizDataBase.quizDao().get(id));
    }

}



