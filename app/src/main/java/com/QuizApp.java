package com;

import android.app.Application;

import androidx.room.Room;

import com.data.IQuizApiClient;
import com.data.QuizRepository;
import com.data.remote.HistoryStorage;
import com.data.remote.IHistoryStorage;
import com.data.remote.QuizApiClient;
import com.db.QuizDataBase;

public class QuizApp extends Application {
public static IQuizApiClient quizApiClient;
private static IHistoryStorage historyStorage;
public  static QuizDataBase quizDataBase;
public QuizRepository repository;

@Override
    public void onCreate() {
        super.onCreate();

        quizDataBase= Room.databaseBuilder(this,
                QuizDataBase.class,
                "quiz.db").
                fallbackToDestructiveMigration().
                allowMainThreadQueries().
                build();
        historyStorage=new HistoryStorage();

   quizApiClient=new QuizApiClient();

    repository=new QuizRepository(quizApiClient,historyStorage,quizDataBase.quizDao());

}





}
