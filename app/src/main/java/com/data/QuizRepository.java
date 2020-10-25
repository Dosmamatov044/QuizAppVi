package com.data;

import androidx.lifecycle.LiveData;

import com.example.quizappvi.ui.fragments.History.History;
import com.example.quizappvi.ui.fragments.History.IHistoryStorage;
import com.db.QuizDao;
import com.model.Question;
import com.model.QuestionResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class QuizRepository implements IHistoryStorage ,IQuizApiClient {
private IQuizApiClient quizApiClient;

    private IHistoryStorage historyStorage;
    private QuizDao quizDao;
    public QuizRepository(IQuizApiClient quizApiClient, IHistoryStorage historyStorage, QuizDao quizDao) {
        this.quizApiClient = quizApiClient;
   this.historyStorage=historyStorage;
this.quizDao=quizDao;
    }


    @Override
    public void getQuestions(int amount, Integer category, String difficulty, QuestionCallback callback) {
        quizApiClient.getQuestions(amount, category, difficulty, new QuestionCallback() {
            @Override
            public void onSuccess(List<Question> questions) {

                for(int i=0;i<questions.size();i++) {
                    questions.set(i,shuffleAnswer(questions.get(i)));

                }
                callback.onSuccess(questions);

            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }

    private Question shuffleAnswer(Question question){

    ArrayList<String>answers=new ArrayList<>();
    answers.add(question.getCorrectAnswer());
    answers.addAll(question.getIncorrect()) ;
    Collections.shuffle(answers);
   // question.setAnswers();


  return question;
}



    @Override
    public QuestionResult getQuestionResult(int id) {
        return historyStorage.getQuestionResult(id);
    }

    @Override
    public int saveQuestionResult(QuestionResult questionResult) {
        return historyStorage.saveQuestionResult(questionResult);
    }

    @Override
    public LiveData<List<QuestionResult>> getAll() {
        return historyStorage.getAll();
    }

    @Override
    public LiveData<List<History>> getAllHistory() {
        return historyStorage.getAllHistory();
    }

    @Override
    public void delete(int id) {
      historyStorage.delete(id);
    }

    @Override
    public void deleteAll() {
        historyStorage.deleteAll();
    }
}
