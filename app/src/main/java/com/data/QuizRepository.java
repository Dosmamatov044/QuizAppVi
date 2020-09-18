package com.data;

import androidx.lifecycle.LiveData;

import com.data.remote.IHistoryStorage;
import com.db.QuizDao;
import com.model.Question;
import com.model.QuestionResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class QuizRepository implements IHistoryStorage,IQuizApiClient {
private IQuizApiClient quizApiClient;
private IHistoryStorage historyStorage;
private QuizDao quizDao;

    public QuizRepository(IQuizApiClient quizApiClient, IHistoryStorage historyStorage,QuizDao quizDao) {
        this.quizApiClient = quizApiClient;
        this.historyStorage = historyStorage;
   this.quizDao=quizDao;
    }






    public void getQuestions(final IQuizApiClient.QuestionCallback callback){


        quizApiClient.getQuestions(0,0,null,new QuestionCallback() {
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
    public void getQuestions(Integer amount, Integer category, String difficulty, QuestionCallback callback) {

    }

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
