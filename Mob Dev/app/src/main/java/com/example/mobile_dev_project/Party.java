package com.example.mobile_dev_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Party extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}