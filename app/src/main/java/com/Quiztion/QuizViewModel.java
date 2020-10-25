package com.Quiztion;
import android.os.CountDownTimer;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.QuizApp;
import com.SingleLIveEvent;
import com.data.IQuizApiClient;
import com.data.QuizRepository;
import com.model.Question;
import com.model.QuestionResult;
import java.util.Date;
import java.util.List;



                                public class QuizViewModel extends ViewModel {
                                    private QuizRepository quizRepository = QuizApp.repository;

                                    MutableLiveData<List<Question>> questions = new MutableLiveData<>();
                                    MutableLiveData<Integer> currentQuestionPosition = new MutableLiveData<>();
                                    private List<Question> mQuestions;

                                    private IQuizApiClient quizApiClient = QuizApp.quizApiClient;
                                    String resultCategory;
                                    Integer category;
                                    String resultDifficulty;
                                    int count1 = 0;
                                    private int id;

                                    MutableLiveData<Boolean> finish = new MutableLiveData<>();

                                    SingleLIveEvent<Void> finishEvent = new SingleLIveEvent<>();
                                    SingleLIveEvent<Integer> openResultEvent = new SingleLIveEvent<>();
                                    View view;


                                    void init(Integer amountCount, Integer category, String difficulty) {

                                       this.category=category;
                                        QuizApp.repository.getQuestions(amountCount, category, difficulty, new IQuizApiClient.QuestionCallback() {
                                            @Override
                                            public void onSuccess(List<Question> result) {


                                                mQuestions = result;
                                                questions.setValue(mQuestions);
                                                currentQuestionPosition.setValue(0);
                                                if (result.size() > 0) {
                                                    resultCategory = mQuestions.get(0).getCategory();


                                                } else {
                                                    resultCategory = "All";
                                                }
                                                if (difficulty != null && result.size() > 0) {
                                                    resultDifficulty = mQuestions.get(0).getDifficulty();
                                                } else {
                                                    resultDifficulty = "Any";
                                                }

                                            }

                                            @Override
                                            public void onFailure(Exception e) {

                                            }
                                        });
                                    }


                                    void onSkipClick() {
                                        Integer currentPosition = currentQuestionPosition.getValue();
                                        if (currentPosition != null) {
                                            onAnswerClick(currentPosition, -1);

                                        }else {
                                            finishQuiz();
                                        }
                                    }


                                    void onBack() {
                                        if (mQuestions.size() != 0) {

                                            currentQuestionPosition.setValue(currentQuestionPosition.getValue() - 1);


                                        } else {
                                            finishEvent.call();
                                        }


                                    }

                                    public void noClick() {


                                        if (mQuestions.size() == (currentQuestionPosition.getValue() - 1)) {

                                            view.setClickable(false);


                                        }

                                    }


                                    public void onAnswerClick(int position, int selectAnswerPosition) {


                                        if (mQuestions.size() > position && position >= 0) {


                                            mQuestions.get(position).setSelectAnswerPosition(selectAnswerPosition);

                                            mQuestions.get(position).setAnswered(true);

                                            questions.setValue(mQuestions);
                                            if (position + 1 == mQuestions.size()) {


                                                finishQuiz();


                                            } else {
                                                int seconds = 0;
                                                CountDownTimer countDownTimer = new CountDownTimer(seconds * 5000, 5000) {
                                                    @Override
                                                    public void onTick(long millisUntilFinished) {


                                                    }

                                                    @Override
                                                    public void onFinish() {
                                                        currentQuestionPosition.setValue(++count1);
                                                    }
                                                }.start();
                                            }
                                        }

                                    }

                                    public void finishQuiz() {
                                        try {


                                            QuestionResult quizResult = new QuestionResult(
                                                    id, resultCategory
                                                    ,
                                                    resultDifficulty,
                                                    getCorrectAnswersAmount(),
                                                    questions.getValue(),
                                                    new Date());
                                            int result = quizRepository.saveQuestionResult(quizResult);
                                            finishEvent.call();
                                            openResultEvent.setValue(result);
                                        } catch (NullPointerException ignored) {
                                        }
                                    }





                                    public int getCorrectAnswersAmount() {

                                        int correctAnswers = 0;
                                        for (Question question : mQuestions) {
                                            Integer selectedAnswerPosition = question.getSelectAnswerPosition()-1;
                                            if (selectedAnswerPosition != null &&
                                                    selectedAnswerPosition >= 0 &&
                                                    question.getAnswers().get(selectedAnswerPosition).equals(question.getCorrectAnswer())) {
                                                correctAnswers++;
                                            }
                                        }
                                        return correctAnswers++;

                                }}



