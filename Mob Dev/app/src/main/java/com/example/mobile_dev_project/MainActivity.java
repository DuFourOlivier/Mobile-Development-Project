package com.example.mobile_dev_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
//Todo: -alle theorie/labo's, recycler view, navigatie bar
//Todo: echte informatie in database
//Todo: google maps
//Todo: navigatie bar
//Todo: recycler view
//Todo:extern openen van sites in app zelf
//Todo: filter optie
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void NavigateToNieuws(View view) {
        Intent intent = new Intent(this,NieuwsTablad.class);
        startActivity(intent);
    }

    public void NavigateToPlaatsen(View view) {
        Intent intent = new Intent(this,Bekende_Plaatsen.class);
        startActivity(intent);
    }

    public void NavigateToEten(View view) {
        Intent intent = new Intent(this,Eten_Drinken.class);
        startActivity(intent);
    }

    public void NavigateToParty(View view) {
        Intent intent = new Intent(this,Party.class);
        startActivity(intent);
    }
}