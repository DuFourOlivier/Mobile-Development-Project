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

    @ColumnInfo(name = "picture")
    private String mpicture;

    @ColumnInfo(name = "catogorie")
    private String mcatogorie;

    public Word(@NonNull String word ,@NonNull String mtitel , String mpicture, String mcatogorie)
    {
        this.mWord = word;
        this.mtitel = mtitel;
        this.mpicture = mpicture;
        this.mcatogorie = mcatogorie;
    }

    public String getWord()
    {
        return this.mWord;
    }
    public String getMtitel() { return this.mtitel;}
    public String getMpicture() { return this.mpicture;}
    public String getMcatogorie() {return this.mcatogorie;}



}
