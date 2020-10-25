package com.example.quizappvi.ui.fragments.History;

import androidx.lifecycle.LiveData;


import com.example.quizappvi.ui.fragments.History.History;
import com.model.QuestionResult;

import java.util.List;

public interface IHistoryStorage {

    QuestionResult getQuestionResult(int id);

    void delete(int id);

    int saveQuestionResult(QuestionResult quizResult);



    LiveData<List<QuestionResult>> getAll();

    LiveData<List<History>> getAllHistory();

      void  deleteAll();
}
