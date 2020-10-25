package com.example.quizappvi.ui.fragments.History;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.QuizApp;
import com.Helper.SingleLIveEvent;

import java.util.List;

public class HistoryViewModel extends ViewModel {
    public LiveData<List<History>> history = QuizApp.historyStorage.getAllHistory();
    public SingleLIveEvent<Void> deleteById = new SingleLIveEvent<>();

    public void delete() {
        deleteById.call();
    }
}