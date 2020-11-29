package com.example.mobile_dev_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Bekende_Plaatsen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bekende__plaatsen);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}