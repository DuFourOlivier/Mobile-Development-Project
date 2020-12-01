package com.example.mobile_dev_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NieuwsTablad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nieuws_tablad);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.nav_nieuws);

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
}