package com.example.mobile_dev_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.LinkedList;

public class Party extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private WordListAdapter mWordListAdapter;

    private final LinkedList<String> mWordList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.nav_feesten);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_feesten:
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
        for (int i = 0; i < 20; i++) {
            mWordList.addLast("partyyyyyy " + i);
        }


        mRecyclerView = findViewById(R.id.Recycler);
        mWordListAdapter = new WordListAdapter(this,mWordList);
        mRecyclerView.setAdapter(mWordListAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}