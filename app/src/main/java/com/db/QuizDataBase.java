package com.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.model.QuestionResult;
@Database(entities = {QuestionResult.class},version=1)
public abstract class QuizDataBase extends  RoomDatabase {



    public  abstract QuizDao quizDao();

}


