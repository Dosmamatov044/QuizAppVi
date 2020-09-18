package com.data.remote;

import androidx.lifecycle.LiveData;

import com.model.Question;
import com.model.QuestionResult;

import java.util.List;

public interface IHistoryStorage {

    QuestionResult getQuestionResult(int id);

    int saveQuestionResult(QuestionResult questionResult);

    LiveData<List<QuestionResult>>getAll();
    void delete(int id);
    void deleteAll();



}
