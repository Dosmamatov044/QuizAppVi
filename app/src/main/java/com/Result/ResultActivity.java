package com.Result;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.QuizApp;
import com.example.quizappvi.R;
import com.model.QuestionResult;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultActivity extends AppCompatActivity {

    private static String ID = "id";
    private ResultViewModel mResultViewModel;
           int id;
    @BindView(R.id.result_category)
    TextView resultCategory;
    @BindView(R.id.result_ans)
    TextView resultCorrectAnswers;
    @BindView(R.id.result_all)
    TextView resultDifficulty;
    @BindView(R.id.result_percents)
    TextView resultPercent;
    @BindView(R.id.result_button_finish)
    Button resultFinishButton;



    public static void start(Context context, int resultId) {
        context.startActivity(new Intent(context, ResultActivity.class).putExtra(ID, resultId));

    }


    public  void changeTheme(){

        setTheme(QuizApp.preferences.getTheme(R.style.AppTheme));


    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        changeTheme();

        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);
        mResultViewModel = ViewModelProviders.of(this).get(ResultViewModel.class);
        id = getIntent().getIntExtra(ID, 1);
        mResultViewModel.getResult(id);
        initResultViewModel();

resultFinishButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        finish();

    }
});

    }

    @SuppressLint("SetTextI18n")
    private void initResultViewModel()  {try {



        mResultViewModel.quizResultMutableLiveData.observe(this, quizResult -> {
            resultCategory.setText(String.valueOf(quizResult.getQuestions().get(0).getCategory()));
            resultDifficulty.setText(String.valueOf(quizResult.getQuestions().get(0).getDifficulty()));
            resultCorrectAnswers.setText(
                    String.valueOf(quizResult.getCorrectAnswerResult()));

            int stat = quizResult.getCorrectAnswerResult() * 100 / quizResult.getQuestions().size();
            resultPercent.setText(String.valueOf(stat + "%"));



        });
    }catch (Exception e){}}




}





