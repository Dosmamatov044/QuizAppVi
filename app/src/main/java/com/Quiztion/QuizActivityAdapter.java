package com.Quiztion;

import android.annotation.SuppressLint;
import android.graphics.Color;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.EType;

import com.example.quizappvi.R;
import com.example.quizappvi.databinding.QuizlistBinding;
import com.model.Question;




import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class QuizActivityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    public List<Question> list ;

    private Listener listener;




    public QuizActivityAdapter(Listener listener, List <Question>list) {
        this.listener = listener;
    this.list=list;
    }
    public List<Question> getListPosition() {
        return list;
    }

    @NonNull
    @Override
    public ViewHolderQuizActivity onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View layoutInflater = LayoutInflater.from(parent.getContext()).inflate(R.layout.quizlist, parent, false);

        return new ViewHolderQuizActivity(layoutInflater, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ViewHolderQuizActivity) {
            ((ViewHolderQuizActivity) holder).onBind(list.get(position), position);


        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setQuestions(List<Question> questions) {
        list.clear();
        list.addAll(questions);
        notifyDataSetChanged();
    }


    public static class ViewHolderQuizActivity extends RecyclerView.ViewHolder implements View.OnTouchListener {
      QuizlistBinding binding;

        Integer position;

        @BindView(R.id.btn1)
        TextView btn1;
        @BindView(R.id.btn2)
        Button btn2;
        @BindView(R.id.btn3)
        Button btn3;
        @BindView(R.id.btn4)
        Button btn4;
        @BindView(R.id.booleanContainer)
        LinearLayout booleanConteiner;
        @BindView(R.id.multiplyContainer)
        LinearLayout multiplyContainer;

        @BindView(R.id.trueOrfalse1)
        Button trueOrFalse;
        @BindView(R.id.trueOrfalse2)
        Button trueOrFalse2;
        @BindView(R.id.quzz)
        TextView question_tv;


        Listener listener;


        @SuppressLint("ClickableViewAccessibility")
        public ViewHolderQuizActivity(@NonNull View itemView, Listener listener) {
            super(itemView);
binding=QuizlistBinding.bind(itemView);


            ButterKnife.bind(this, itemView);



            this.listener = listener;


           binding.btn1.setOnTouchListener(this);
            binding.btn2.setOnTouchListener(this);
            binding.btn3.setOnTouchListener(this);
            binding.btn4.setOnTouchListener(this);
            binding.trueOrfalse1.setOnTouchListener(this);
           binding.trueOrfalse2.setOnTouchListener(this);

onClick();


        }


        @SuppressLint("SetTextI18n")
        public void onBind(Question question, int position) {


            clearHolder();

            this.position = position;


            if (question.isAnswered()) {
                setButtonsEnabled(false);

            } else {
                setButtonsEnabled(true);

            }
            question_tv.setText(Html.fromHtml(question.getQuestion()));
            if (question.getType() != null) {


                if (question.getType() == EType.MULTIPLE) {
                   binding. multiplyContainer.setVisibility(View.VISIBLE);
                   binding.booleanContainer.setVisibility(View.GONE);


                   binding.btn1.setText(Html.fromHtml(question.getAnswers().get(0)));

                   binding.btn2.setText(Html.fromHtml(question.getAnswers().get(1)));

                  binding.btn3.setText(Html.fromHtml(question.getAnswers().get(2)));
                  binding.btn4.setText(Html.fromHtml(question.getAnswers().get(3)));

                } else if (question.getType() == EType.BOOLEAN) {
                   binding.multiplyContainer.setVisibility(View.GONE);
                   binding.booleanContainer.setVisibility(View.VISIBLE);
                   binding.trueOrfalse1.setText(Html.fromHtml(question.getAnswers().get(0)));
                   binding. trueOrfalse2.setText(Html.fromHtml(question.getAnswers().get(1)));


                }

            }if (question.isAnswered()){



                btnState(question);
            }


        }


        public  void onClick(){


           binding.btn1.setOnClickListener(v -> listener.onAnswerClick(getAdapterPosition(), 1));
           binding.btn2.setOnClickListener(v -> listener.onAnswerClick(getAdapterPosition(), 2));
          binding.btn3.setOnClickListener(v -> listener.onAnswerClick(getAdapterPosition(), 3));
           binding.btn4.setOnClickListener(v -> listener.onAnswerClick(getAdapterPosition(), 4));

          binding.trueOrfalse1.setOnClickListener(v -> listener.onAnswerClick(getAdapterPosition(), 1));
          binding.trueOrfalse2.setOnClickListener(v -> listener.onAnswerClick(getAdapterPosition(), 2));


        }

        public void btnState(Question question) {
if (question.getSelectAnswerPosition()!=null){
            switch (question.getSelectAnswerPosition()) {
                case 1:
                    if (question.getCorrectAnswer().equals(question.getAnswers().get(0))) {
                      binding.btn1.setBackgroundResource(R.drawable.item_button_2);
                       binding.trueOrfalse1.setBackgroundResource(R.drawable.item_button_2);
                    } else {
                       binding.btn1.setBackgroundResource(R.drawable.item_button_3);
                      binding.btn1.setBackgroundResource(R.drawable.item_button_3);
                    }
                   binding.btn1.setTextColor(Color.WHITE);
                   binding.trueOrfalse1.setTextColor(Color.WHITE);
                    break;
                case 2:
                    if (question.getCorrectAnswer().equals(question.getAnswers().get(1))) {
                        binding.btn2.setBackgroundResource(R.drawable.item_button_2);
                      binding.trueOrfalse2.setBackgroundResource(R.drawable.item_button_2);
                    } else {
                       binding.btn2.setBackgroundResource(R.drawable.item_button_3);
                        binding.trueOrfalse2.setBackgroundResource(R.drawable.item_button_3);
                    }
                    binding.btn2.setTextColor(Color.WHITE);
                   binding.btn2.setTextColor(Color.WHITE);
                    break;
                case 3:
                    if (question.getCorrectAnswer().equals(question.getAnswers().get(2))) {
                       binding. btn3.setBackgroundResource(R.drawable.item_button_2);
                    } else {
                      binding.btn3.setBackgroundResource(R.drawable.item_button_3);
                    }
                   binding.btn3.setTextColor(Color.WHITE);
                    break;
                case 4:
                    if (question.getCorrectAnswer().equals(question.getAnswers().get(3))) {
                       binding.btn4.setBackgroundResource(R.drawable.item_button_2);
                    } else {
                      binding.btn4.setBackgroundResource(R.drawable.item_button_3);
                    }
                   binding.btn4.setTextColor(Color.WHITE);
                    break;
            }}


        }




        private void clearHolder() {
           binding.btn1.setBackgroundResource(R.drawable.background1);
           binding.btn2.setBackgroundResource(R.drawable.background1);
           binding.btn3.setBackgroundResource(R.drawable.background1);
           binding.btn4.setBackgroundResource(R.drawable.background1);
           binding. trueOrfalse1.setBackgroundResource(R.drawable.background1);
           binding.trueOrfalse2.setBackgroundResource(R.drawable.background1);
           binding.btn1.setTextColor(Color.BLACK);
           binding.btn2.setTextColor(Color.BLACK);
            binding.btn3.setTextColor(Color.BLACK);
            binding.btn4.setTextColor(Color.BLACK);
            binding.trueOrfalse1.setTextColor(Color.BLACK);
            binding.trueOrfalse2.setTextColor(Color.BLACK);
        }

        public void setButtonsEnabled(boolean show) {
           binding.btn1.setEnabled(show);
           binding.btn2.setEnabled(show);
           binding.btn3.setEnabled(show);
           binding.btn4.setEnabled(show);
           binding.trueOrfalse1.setEnabled(show);
           binding.trueOrfalse2.setEnabled(show);


        }



        @SuppressLint("ClickableViewAccessibility")
        @Override
        public boolean onTouch(View v, MotionEvent event) {


            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:


                    return false;

                case MotionEvent.ACTION_UP:


                    return false;

            }


            return false;
        }
    }

    public interface Listener {
        void onAnswerClick(int position, int selectedAnswerPosition);
    }



}