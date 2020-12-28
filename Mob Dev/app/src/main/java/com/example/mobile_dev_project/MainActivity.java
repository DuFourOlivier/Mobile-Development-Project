package com.example.mobile_dev_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;






public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*2
        Coding, A. (2019, 10 november). How to Implement Bottom Navigation With Activities in Android Studio | BottomNav | Android Coding. YouTube.
        https://www.youtube.com/watch?v=JjfSjMs0ImQ&feature=youtu.be
        */
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
                        startActivity(new Intent(getApplicationContext(), Horeca.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_nieuws:
                        startActivity(new Intent(getApplicationContext(),NieuwsTablad.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_plaats:
                        startActivity(new Intent(getApplicationContext(), Toerisme.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });






}}