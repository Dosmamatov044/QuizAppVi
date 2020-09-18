package com.data.remote;

import androidx.lifecycle.LiveData;

import com.model.QuestionResult;

import java.util.List;

public class HistoryStorage implements IHistoryStorage {


    @Override
    public QuestionResult getQuestionResult(int id) {
        return null;
    }

    @Override
    public int saveQuestionResult(QuestionResult questionResult) {
        return 0;
    }

    @Override
    public LiveData<List<QuestionResult>> getAll() {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void deleteAll() {

    }
}
