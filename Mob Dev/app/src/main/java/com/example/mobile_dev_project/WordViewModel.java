package com.example.mobile_dev_project;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private WordRepository mRepository;
    private LiveData<List<Word>> mAllwords;


    public WordViewModel( Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mAllwords = mRepository.getAllWords();

    }
    LiveData<List<Word>> getAllWords(WordRoomDatabase.Categoriën cat)
    {
        switch (cat) {
            case Toerisme:
                return mRepository.getAllToerismeWords();

            case Horeca:
                return mRepository.getAllHorecaWords();

            case Nieuws:
                return mRepository.getAllNieuwsWords();

            case Feesten:
                return  mRepository.getAllFeestenWords();

            default:
                return mAllwords;
         

        }


    }
    public void insert(Word word)
    {
        mRepository.insert(word);
    }
}
