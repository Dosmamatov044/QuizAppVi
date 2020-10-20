package com.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.model.QuestionResult;
@Database(entities = {QuestionResult.class},version=4,exportSchema = false)



public abstract class QuizDataBase extends  RoomDatabase {



    public  abstract QuizDao quizDao();

}


