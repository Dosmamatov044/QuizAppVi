package com.example.quizappvi.ui.fragments.History;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;


import com.db.QuizDao;
import com.model.QuestionResult;

import java.util.ArrayList;
import java.util.List;

public class HistoryStorage implements IHistoryStorage {
private QuizDao quizDao;

    public HistoryStorage(QuizDao quizDao) {
  this.quizDao=quizDao;

    }

    @Override
    public QuestionResult getQuestionResult(int id) {
        return quizDao.get(id);
    }

    @Override
    public void delete(int id) {
       
    }

    @Override
    public int saveQuestionResult(QuestionResult questionResult) {
        return (int) quizDao.insert(questionResult);
    }

    @Override
    public LiveData<List<QuestionResult>> getAll() {
        return quizDao.getAll();
    }



    @Override
    public LiveData<List<History>> getAllHistory() {
        return Transformations.map(getAll(), new Function<List<QuestionResult>, List<History>>() {
            @Override
            public List<History> apply(List<QuestionResult> quizResult) {
                ArrayList<History> histories = new ArrayList<>();
                if (quizResult.size() > 0) {
                    for (int i = 0; i < quizResult.size(); i++) {
                        histories.add(i, new History(
                                quizResult.get(i).getId(),
                                quizResult.get(i).getCategory(),
                                quizResult.get(i).getDifficulty(),
                                quizResult.get(i).getCorrectAnswerResult(),
                                quizResult.get(i).getQuestions().size(),
                                quizResult.get(i).getCreatedAt()));
                    }
                }
                return histories;
            }


        });


    }

    @Override
    public void deleteAll() {
quizDao.deleteAll();
    }


}
