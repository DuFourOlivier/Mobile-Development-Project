package com.example.mobile_dev_project;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "word_table")
public class Word {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String mWord;

    @NonNull
    @ColumnInfo(name = "titel")
    private String mtitel;

    public Word(@NonNull String word ,@NonNull String mtitel)
    {
        this.mWord = word;
        this.mtitel = mtitel;
    }

    public String getWord()
    {
        return this.mWord;
    }
    public String getMtitel() { return this.mtitel;}
}
