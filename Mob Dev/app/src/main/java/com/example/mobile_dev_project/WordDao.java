package com.example.mobile_dev_project;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WordDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Word word);

    @Query("DELETE FROM word_table")
    void deleteAll();

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    LiveData<List<Word>> getAllWords();

    @Query("SELECT * FROM word_table WHERE catogorie ='Nieuws'   ORDER BY word ASC")
    LiveData<List<Word>> getAllNieuwsWords();

    @Query("SELECT * FROM word_table WHERE catogorie ='Toerisme'   ORDER BY word ASC")
    LiveData<List<Word>> getAllToerismeWords();

    @Query("SELECT * FROM word_table WHERE catogorie ='Horeca'   ORDER BY word ASC")
    LiveData<List<Word>> getAllHorecaWords();
    @Query("SELECT * FROM word_table WHERE catogorie ='Feesten'   ORDER BY word ASC")
    LiveData<List<Word>> getAllFeestenWords();


}
