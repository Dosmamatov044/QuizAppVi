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
            ButterKnife.bind(this, itemView);

            this.listener = listener;


            btn1.setOnTouchListener(this);
            btn2.setOnTouchListener(this);
            btn3.setOnTouchListener(this);
            btn4.setOnTouchListener(this);
            trueOrFalse.setOnTouchListener(this);
            trueOrFalse2.setOnTouchListener(this);

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
                    multiplyContainer.setVisibility(View.VISIBLE);
                    booleanConteiner.setVisibility(View.GONE);


                    btn1.setText(Html.fromHtml(question.getAnswers().get(0)));

                    btn2.setText(Html.fromHtml(question.getAnswers().get(1)));

                    btn3.setText(Html.fromHtml(question.getAnswers().get(2)));
                    btn4.setText(Html.fromHtml(question.getAnswers().get(3)));

                } else if (question.getType() == EType.BOOLEAN) {
                    multiplyContainer.setVisibility(View.GONE);
                    booleanConteiner.setVisibility(View.VISIBLE);
                    trueOrFalse.setText(Html.fromHtml(question.getAnswers().get(0)));
                    trueOrFalse2.setText(Html.fromHtml(question.getAnswers().get(1)));


                }

            }if (question.isAnswered()){



                btnState(question);
            }


        }


        public  void onClick(){


            btn1.setOnClickListener(v -> listener.onAnswerClick(getAdapterPosition(), 1));
            btn2.setOnClickListener(v -> listener.onAnswerClick(getAdapterPosition(), 2));
            btn3.setOnClickListener(v -> listener.onAnswerClick(getAdapterPosition(), 3));
            btn4.setOnClickListener(v -> listener.onAnswerClick(getAdapterPosition(), 4));

            trueOrFalse.setOnClickListener(v -> listener.onAnswerClick(getAdapterPosition(), 1));
            trueOrFalse2.setOnClickListener(v -> listener.onAnswerClick(getAdapterPosition(), 2));


        }

        public void btnState(Question question) {
if (question.getSelectAnswerPosition()!=null){
            switch (question.getSelectAnswerPosition()) {
                case 1:
                    if (question.getCorrectAnswer().equals(question.getAnswers().get(0))) {
                        btn1.setBackgroundResource(R.drawable.item_button_2);
                        trueOrFalse.setBackgroundResource(R.drawable.item_button_2);
                    } else {
                        btn1.setBackgroundResource(R.drawable.item_button_3);
                        btn1.setBackgroundResource(R.drawable.item_button_3);
                    }
                    btn1.setTextColor(Color.WHITE);
                    trueOrFalse.setTextColor(Color.WHITE);
                    break;
                case 2:
                    if (question.getCorrectAnswer().equals(question.getAnswers().get(1))) {
                        btn2.setBackgroundResource(R.drawable.item_button_2);
                        trueOrFalse2.setBackgroundResource(R.drawable.item_button_2);
                    } else {
                        btn2.setBackgroundResource(R.drawable.item_button_3);
                        trueOrFalse2.setBackgroundResource(R.drawable.item_button_3);
                    }
                    btn2.setTextColor(Color.WHITE);
                    btn2.setTextColor(Color.WHITE);
                    break;
                case 3:
                    if (question.getCorrectAnswer().equals(question.getAnswers().get(2))) {
                        btn3.setBackgroundResource(R.drawable.item_button_2);
                    } else {
                        btn3.setBackgroundResource(R.drawable.item_button_3);
                    }
                    btn3.setTextColor(Color.WHITE);
                    break;
                case 4:
                    if (question.getCorrectAnswer().equals(question.getAnswers().get(3))) {
                        btn4.setBackgroundResource(R.drawable.item_button_2);
                    } else {
                        btn4.setBackgroundResource(R.drawable.item_button_3);
                    }
                    btn4.setTextColor(Color.WHITE);
                    break;
            }}


        }




        private void clearHolder() {
            btn1.setBackgroundResource(R.drawable.background1);
            btn2.setBackgroundResource(R.drawable.background1);
            btn3.setBackgroundResource(R.drawable.background1);
            btn4.setBackgroundResource(R.drawable.background1);
            trueOrFalse.setBackgroundResource(R.drawable.background1);
            trueOrFalse2.setBackgroundResource(R.drawable.background1);
            btn1.setTextColor(Color.BLACK);
            btn2.setTextColor(Color.BLACK);
            btn3.setTextColor(Color.BLACK);
            btn4.setTextColor(Color.BLACK);
            trueOrFalse.setTextColor(Color.BLACK);
            trueOrFalse2.setTextColor(Color.BLACK);
        }

        public void setButtonsEnabled(boolean show) {
            btn1.setEnabled(show);
            btn2.setEnabled(show);
            btn3.setEnabled(show);
            btn4.setEnabled(show);
            trueOrFalse.setEnabled(show);
            trueOrFalse2.setEnabled(show);


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