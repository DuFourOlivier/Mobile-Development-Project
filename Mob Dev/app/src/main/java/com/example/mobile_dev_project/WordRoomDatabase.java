package com.example.mobile_dev_project;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Database(entities = {Word.class}, version = 1,exportSchema = false)
public abstract class WordRoomDatabase extends RoomDatabase {
    public abstract WordDao wordDao();

    private static WordRoomDatabase INSTANCE;

     static WordRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WordRoomDatabase.class) {
                if (INSTANCE == null) {
                    // database creation
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), WordRoomDatabase.class, "word_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };
    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final WordDao mDao;



        PopulateDbAsync(WordRoomDatabase db) {
            mDao = db.wordDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            List<Word> woordjes = new ArrayList<Word>();

            woordjes.add(new Word("Hallo","andere halloo"));
            woordjes.add(new Word("dfgdfgfdg","andere halloo"));
            woordjes.add(new Word("zerezre","andere halloo"));
            woordjes.add(new Word("Hallgeo","andere halloo"));
            woordjes.add(new Word("Haldlo","andere halloo"));
            woordjes.add(new Word("Halqdqlo","andere halloo"));
            woordjes.add(new Word("Hasdqqsllo","andere halloo"));
            woordjes.add(new Word("Haldddlo","andere halloo"));
            woordjes.add(new Word("Halggglo","andere halloo"));
            woordjes.add(new Word("Hacxxwxllo","andere halloo"));
            woordjes.add(new Word("Hadddllo","andere halloo"));
            // Start the app with a clean database every time.
            // Not needed if you only populate the database
            // when it is first created
            mDao.deleteAll();

            for (int i = 0; i <= woordjes.size() - 1; i++) {
                mDao.insert(woordjes.get(i));
            }
            return null;
        }
    }

}
