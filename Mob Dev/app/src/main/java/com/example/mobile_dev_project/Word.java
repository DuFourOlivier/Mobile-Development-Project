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

    @NonNull
    @ColumnInfo(name = "picture")
    private String mpicture;

    public Word(@NonNull String word ,@NonNull String mtitel ,@NonNull String mpicture)
    {
        this.mWord = word;
        this.mtitel = mtitel;
        this.mpicture = mpicture;
    }

    public String getWord()
    {
        return this.mWord;
    }
    public String getMtitel() { return this.mtitel;}
    public String getMpicture() { return this.mpicture;}
}
