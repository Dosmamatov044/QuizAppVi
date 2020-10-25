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
public static IHistoryStorage historyStorage;
public  static QuizDataBase quizDataBase;
public static QuizRepository repository;
public  static  Preferences preferences;


@Override
    public void onCreate() {
        super.onCreate();
    preferences=new Preferences(this);
        quizDataBase= Room.databaseBuilder(this,
                QuizDataBase.class,
                "quiz.db").
                fallbackToDestructiveMigration().
                allowMainThreadQueries().
                build();
        historyStorage=new HistoryStorage(quizDataBase.quizDao());

   quizApiClient=new QuizApiClient();

    repository=new QuizRepository(quizApiClient,historyStorage,quizDataBase.quizDao());

}





}
