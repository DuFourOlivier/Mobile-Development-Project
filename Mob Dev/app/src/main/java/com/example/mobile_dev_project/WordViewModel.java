package com.example.roomwordssample;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private WordRepository mRepository;
    private LiveData<List<Word>> mAllwords;


    public void deleteAll()
    {
        mRepository.deleteAll();
    }
    public void deleteWord(Word word)
    {
        mRepository.deleteWord(word);
    }

    public WordViewModel(@NonNull Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mAllwords = mRepository.getmAllWords();

    }
    LiveData<List<Word>> getAllWords()
    {
        return mAllwords;
    }
    public void insert(Word word)
    {
        mRepository.insert(word);
    }
}
