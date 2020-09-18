package com.Quiztion;

import android.annotation.SuppressLint;
import android.text.Html;
import android.view.LayoutInflater;
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


    List <Question> list=new ArrayList<>();

 private Listener listener;

    public void update(List<Question> list) {
        this.list = list;
notifyDataSetChanged();


    }




    public QuizActivityAdapter(Listener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolderQuizActivity onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View layoutInflater=LayoutInflater.from(parent.getContext()).inflate(R.layout.quizlist,parent,false);

        return new ViewHolderQuizActivity(layoutInflater, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ViewHolderQuizActivity){
            ((ViewHolderQuizActivity)holder).onBind(list.get(position),position);


    }}
        @Override
        public int getItemCount() {
            return list.size();
        }

    public void setQuestions(List<Question> questions){
        list.clear();
        list.addAll(questions);
        notifyDataSetChanged();
    }



  public  static class ViewHolderQuizActivity extends RecyclerView.ViewHolder {

      private static final String TRUE ="true" ;
      int position;

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

       @BindView(R.id.trueOrfalse1)Button trueOrFalse;
       @BindView(R.id.trueOrfalse2)Button trueOrFalse2;
@BindView(R.id.quzz)  TextView question_tv;







 Listener listener;

   public    Boolean is=false;
        public ViewHolderQuizActivity(@NonNull View itemView,Listener listener) {
            super(itemView);
            ButterKnife.bind(this,itemView);

this.listener=listener;





btn1.setOnClickListener(v -> listener.onAnswerClick(getAdapterPosition(),1));
btn2.setOnClickListener(v -> listener.onAnswerClick(getAdapterPosition(),2));
btn3.setOnClickListener(v -> listener.onAnswerClick(getAdapterPosition(),3));
btn4.setOnClickListener(v -> listener.onAnswerClick(getAdapterPosition(),4));

trueOrFalse.setOnClickListener(v -> listener.onAnswerClick(getAdapterPosition(),1));
trueOrFalse2.setOnClickListener(v -> listener.onAnswerClick(getAdapterPosition(),2));

        }








        @SuppressLint("SetTextI18n")
        public void onBind(Question question, int position) {


            if (question.isAnswered()) {
                setButtonsEnabled(false);
            } else {
                setButtonsEnabled(true);
            }


            this.position = position;
            question_tv.setText(Html.fromHtml(question.getQuestion()));





            if (question.getType()!=null){
            if (question.getType() == (EType.MULTIPLE)) {

                multiplyContainer.setVisibility(View.VISIBLE);
                booleanConteiner.setVisibility(View.GONE);

                btn1.setText(Html.fromHtml(question.getAnswers().get(0)));
                btn2.setText(Html.fromHtml(question.getAnswers().get(1)));
                btn3.setText(Html.fromHtml(question.getAnswers().get(2)));
                btn4.setText(Html.fromHtml(question.getAnswers().get(3)));

              ChangeColor(question);


            } else if (question.getType() == (EType.BOOLEAN)) {

                if (question.getCorrectAnswer().equals(TRUE)) {
                    trueOrFalse.setText("Yes");
                } else {
                    trueOrFalse2.setText("No");
                }
                    multiplyContainer.setVisibility(View.GONE);

                    booleanConteiner.setVisibility(View.VISIBLE);

                    trueOrFalse.setText(Html.fromHtml(question.getAnswers().get(0)));
                    trueOrFalse2.setText(Html.fromHtml(question.getAnswers().get(1)));




            }






            }



        }


      public  void ChangeColor(Question question){


          if (is.equals(question.getCorrectAnswer()))    {
              is=true;
btn1.setBackgroundResource(R.color.dark);


          }


      }


      private void showMultipleQuestion(Question questions) {
         btn1.setText(Html.fromHtml(questions.getAnswers().get(0)));
        btn2.setText(Html.fromHtml(questions.getAnswers().get(1)));
         btn3.setText(Html.fromHtml(questions.getAnswers().get(2)));
          btn4.setText(Html.fromHtml(questions.getAnswers().get(3)));


      }


      public void setButtonsEnabled(boolean show) {
          btn1.setEnabled(show);
          btn2.setEnabled(show);
          btn3.setEnabled(show);
          btn4.setEnabled(show);
          trueOrFalse.setEnabled(show);
          trueOrFalse2.setEnabled(show);


      }








}

    public interface Listener {
        void onAnswerClick(int position, int selectedAnswerPosition);
    }



}


