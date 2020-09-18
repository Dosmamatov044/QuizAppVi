package com.Quiztion;
import android.os.CountDownTimer;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.QuizApp;
import com.data.IQuizApiClient;
import com.model.Question;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



                                public class QuizViewModel extends ViewModel {

Integer count;
    MutableLiveData<List<Question>> questions = new MutableLiveData<>();
    MutableLiveData<Integer> currentQuestionPosition = new MutableLiveData<>();
    private List<Question> mQuestions=new ArrayList<>();

    private IQuizApiClient quizApiClient = QuizApp.quizApiClient;


    void init(Integer amountCount, Integer category, String difficulty) {
        quizApiClient.getQuestions(amountCount, category, difficulty, new IQuizApiClient.QuestionCallback() {
            @Override
            public void onSuccess(List<Question> result) {
                mQuestions = result;
                questions.setValue(mQuestions);
                currentQuestionPosition.setValue(0);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }

    void finishQuiz() {



    }


                                    void  onSkipClick(){
                                        Integer currentPosition = currentQuestionPosition.getValue();
                                        if (currentPosition != null) {
                                            onAnswerClick(currentPosition, -1);
                                        }
                                    }




    void onBackpessed(){
  if (mQuestions.size()!=0){

      currentQuestionPosition.setValue(currentQuestionPosition.getValue() - 1);


  }


    }

    public void onAnswerClick(int position, int selectAnswerPosition) {


        if (mQuestions.size() >= position && position >= 0) {

            currentQuestionPosition.setValue(currentQuestionPosition.getValue() + 1);
            mQuestions.get(position).setSelectAnswerPosition(selectAnswerPosition);
            questions.setValue(mQuestions);

            if (position == mQuestions.size() + 1) {
                finishQuiz();
            }
            }
        }











                                    private int getCorrectAnswersAmount() {
                                        int correctAnswers = 0;

                                        for (Question question : mQuestions) {
                                            int selectedAnswerPosition = question.getSelectAnswerPosition();

                                            if (selectedAnswerPosition >= 0 && question.getAnswers().get(selectedAnswerPosition)
                                                    .equals(question.getCorrectAnswer())) {
                                                correctAnswers++;
                                            }
                                        }

                                        return correctAnswers;
                                    }
}
