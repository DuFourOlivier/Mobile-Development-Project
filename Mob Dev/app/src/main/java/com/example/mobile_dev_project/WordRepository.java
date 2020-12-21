package com.example.mobile_dev_project;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {
    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;


    WordRepository(Application application)
    {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords();


}

    LiveData<List<Word>> getAllWords()
    {
        return  mAllWords;
    }
    LiveData<List<Word>> getAllNieuwsWords()
    {
        return  mWordDao.getAllNieuwsWords();
    }
    LiveData<List<Word>> getAllFeestenWords()
    {
        return  mWordDao.getAllFeestenWords();
    }
    LiveData<List<Word>> getAllHorecaWords()
    {
        return  mWordDao.getAllHorecaWords();
    }
    LiveData<List<Word>> getAllToerismeWords()
    {
        return  mWordDao.getAllToerismeWords();
    }


    public void insert(Word word)
    {
        new insertAsyncTask(mWordDao).execute(word);

    }
    private static class insertAsyncTask extends AsyncTask<Word, Void, Void> {

        private WordDao mAsyncTaskDao;

        insertAsyncTask(WordDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Word... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }






}
