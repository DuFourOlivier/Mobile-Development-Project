package com.example.mobile_dev_project;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

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

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.nav_home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_feesten:
                        startActivity(new Intent(getApplicationContext(),Party.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_horeca:
                        startActivity(new Intent(getApplicationContext(),Eten_Drinken.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_nieuws:
                        startActivity(new Intent(getApplicationContext(),NieuwsTablad.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_plaats:
                        startActivity(new Intent(getApplicationContext(),Bekende_Plaatsen.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });







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




    public void NavigateToHome(MenuItem item) {Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void NavigateToNieuws(MenuItem item) {
        Intent intent = new Intent(this,NieuwsTablad.class);
        startActivity(intent);
    }

    public void NavigateToPlaatsen(MenuItem item) {    Intent intent = new Intent(this,Bekende_Plaatsen.class);
        startActivity(intent);
    }

    public void NavigateToEten(MenuItem item) {       Intent intent = new Intent(this,Eten_Drinken.class);
        startActivity(intent);
    }

    public void NavigateToParty(MenuItem item) {
        Intent intent = new Intent(this,Party.class);
        startActivity(intent);
    }
}