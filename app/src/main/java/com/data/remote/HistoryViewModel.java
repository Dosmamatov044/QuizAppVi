package com.data.remote;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.QuizApp;
import com.SingleLIveEvent;

import java.util.List;

public class HistoryViewModel extends ViewModel {
    public LiveData<List<History>> history = QuizApp.historyStorage.getAllHistory();
    public SingleLIveEvent<Void> deleteById = new SingleLIveEvent<>();

    public void delete() {
        deleteById.call();
    }
}