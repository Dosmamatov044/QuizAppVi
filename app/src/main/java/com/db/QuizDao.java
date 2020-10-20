package com.db;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.model.QuestionResult;
import java.util.List;
@Dao
public interface QuizDao {
@Insert
long insert(QuestionResult questionResult);

@Delete
void delete(QuestionResult questionResult);

@Query("SELECT*FROM questionResult WHERE id=:id")
QuestionResult get(int id);

    @Query("DELETE FROM QuestionResult WHERE id = :id")
    void deleteById(int id);

    @Query("SELECT*FROM questionResult")
    LiveData<List<QuestionResult>>getAll();

    @Query("DELETE FROM questionresult")
    void deleteAll();}
