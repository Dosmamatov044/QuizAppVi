package com.Quiztion;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;

import android.os.Bundle;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.QuizApp;
import com.Result.ResultActivity;
import com.airbnb.lottie.LottieAnimationView;




import com.example.quizappvi.R;



import com.model.Question;



import java.util.ArrayList;
import java.util.List;



import butterknife.ButterKnife;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;

public class QuizActivity extends AppCompatActivity implements QuizActivityAdapter.Listener  {
    QuizViewModel viewModel;
      TextView changeAmountprogress;
   TextView categoryText;

   TextView cText;

    public int position;

    public static final String SEEK_BAR = "amount";
    public static final String DIFF_DIFFICULT = "difficult";

    public static final String CATEGORY_NAME = "category";
      Integer category;
    String  difficulty;
    int amount;
    String categoryForSpinner;
    LottieAnimationView lottie;
    QuizActivityAdapter adapter;
    List<Question> list=new ArrayList<>();

ProgressBar progressBar;
RecyclerView recyclerView;
ImageView image;
Button skip;






    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       changeTheme();

        setContentView(R.layout.activity_qui__light);


       viewModel= ViewModelProviders.of(this).get(QuizViewModel.class);




        ButterKnife.bind(QuizActivity.this);
skip=findViewById(R.id.skip);
image=findViewById(R.id.Vimage);






lottie=findViewById(R.id.animationView);
        progressBar=findViewById(R.id.progressBar);
        changeAmountprogress=findViewById(R.id.progress);
        categoryText=findViewById(R.id.text);

        recyclerView = findViewById(R.id.recyclerQuizActivity);
        adapter = new QuizActivityAdapter(this,list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);


        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,true));

        recyclerView.setOnTouchListener((View v, MotionEvent event) -> {
            return true;
        });
        SnapHelper snapHelper=new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
lottie.setVisibility(View.VISIBLE);

        viewModel = ViewModelProviders.of(this).get(QuizViewModel.class);
       // viewModel.init(amount , category , difficulty);
        viewModel.questions.observe(this, new Observer<List<Question>>() {


            @SuppressLint("SetTextI18n")
            @Override
            public void onChanged(List<Question> questions) {
                adapter.setQuestions(questions);

                categoryText.setText(category.toString());
                 categoryText.setText(categoryForSpinner);

            }});

        getQuizData();
        getPosition();



        viewModel.init(amount ,category, difficulty);

        viewModel.finishEvent.observe(this, aVoid -> {
            finish();
        });

        viewModel.openResultEvent.observe(this, integer -> ResultActivity.start(QuizActivity.this, integer));

    }


    public static void start(Context context, Integer amount, Integer categoryP, String difficultValue, String categoryForSpinner) {

        Intent intent = new Intent(context, QuizActivity.class);
        intent.putExtra(SEEK_BAR, amount);
        intent.putExtra("catkeys", categoryP);
        intent.putExtra(DIFF_DIFFICULT, difficultValue);
        intent.putExtra("category", categoryForSpinner);

        context.startActivity(intent);


    }
    public  void changeTheme(){

        setTheme(QuizApp.preferences.getTheme(R.style.AppTheme));


    }

    private void getQuizData() {

        Intent intent = getIntent();
        amount = intent.getIntExtra(SEEK_BAR, 5);
        category = intent.getIntExtra("catkeys", 1);

        difficulty = intent.getStringExtra(DIFF_DIFFICULT);
        categoryForSpinner = intent.getStringExtra("category");

        if (category == 8) {
            category = 0;
        }

        if (difficulty.equals("Any")) {
            difficulty = null;
        }



        viewModel.questions.observe(this, (List<Question> questions) -> {
            try {


                if ( list.size()!=0) {

lottie.setVisibility(View.GONE);


                    image.setVisibility(View.VISIBLE);

                    skip.setVisibility(View.VISIBLE);
                    list = questions;
                    recyclerView.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.VISIBLE);
                    changeAmountprogress.setVisibility(View.VISIBLE);
                    categoryText.setVisibility(View.VISIBLE);




                    //   categoryText.setText(String.valueOf(categoryForSpinner));





                    progressBar.setMax(list.size());


                    getPosition();


                }

















            }catch (Exception noNull){}
        });






        }









    private void getPosition() {
        try {


            viewModel.currentQuestionPosition.observe(this, new Observer<Integer>() {
                @SuppressLint("SetTextI18n")
             @Override
                public void onChanged(Integer position) {
                    recyclerView.smoothScrollToPosition(position);

                    changeAmountprogress.setText(position + 1 + "/" + adapter.getItemCount());
                    progressBar.setProgress(position + 1);

                    recyclerView.smoothScrollToPosition(position);
                }
            });

        } catch (Exception ignored) {
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @OnClick(R.id.skip)
public  void skipClick(View view){
        Toasty.success(getApplicationContext(), "NEXT", Toast.LENGTH_SHORT, true).show();


        viewModel.onSkipClick();

}
    @OnClick(R.id.Vimage)
     void onBackPressed(View view) {
        viewModel.onBack();





        }

    @Override
    public void onAnswerClick(int position, int selectedAnswerPosition) {
        viewModel.onAnswerClick(position,selectedAnswerPosition); }}