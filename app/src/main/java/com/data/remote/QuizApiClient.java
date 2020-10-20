package com.data.remote;

import android.util.Log;

import com.model.Question;
import com.model.QuizResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.data.IQuizApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class QuizApiClient implements IQuizApiClient {

Retrofit retrofit=new Retrofit
        .Builder()
        .baseUrl("https://opentdb.com/")
        .addConverterFactory(GsonConverterFactory
        .create())
        .build();



private Question shuffleQuestion(Question question){

    ArrayList<String>answers=new ArrayList<>();
    answers.add(question.getCorrectAnswer());
    answers.addAll(question.getIncorrect());
    Collections.shuffle(answers);
    question.setAnswers(answers);



    return question;
}



QuizApi client=retrofit.create(QuizApi.class);





    @Override

   public void getQuestions(int amount,int category,String difficulty,final QuestionCallback callback) {
  Call<QuizResponse>call=client.getQuestions(amount,category,difficulty);
 // Call<QuizResponse>call=client.getQuestions(amount,category,difficulty);
        Log.d("nice","Url"+call.request());




        call.enqueue(new Callback<QuizResponse>() {
            @Override
            public void onResponse(Call<QuizResponse> call, Response<QuizResponse> response) {

                if (response.isSuccessful()){

                 if(response.body()!=null){


                   for (int i=0;i<response.body().getResults().size();i++){

                       Question question=response.body().getResults().get(i);
                       response.body().getResults().set(i,shuffleQuestion(question));

                       callback.onSuccess(response.body().getResults());
                   }




                 }

                }else {

                    callback.onFailure(new Exception("Response is Empty"+response.code()));

                }
            }

            @Override
            public void onFailure(Call<QuizResponse> call, Throwable t) {
           callback.onFailure(new Exception(t.getMessage()));




            }
        });
    }




   public interface  QuizApi{
   @GET("api.php")
    Call<QuizResponse> getQuestions(








       @Query("amount") int amount,

      @Query("category") int category,

        @Query("difficulty") String difficulty);





}
}
