package com.example.cleanenergyapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);

//        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.home:
//                        // Switch to ZoneActivity
//                        Intent homeIntent = new Intent(SettingsActivity.this,ZoneScreen.class);
//                        startActivity(homeIntent);
//                        return true;
//
//                    case R.id.input:
//                        // Switch to MainActivity
//                        Intent inputIntent = new Intent(SettingsActivity.this, MainActivity.class);
//                        startActivity(inputIntent);
//                        return true;
//
//                    case R.id.settings:
//                        // Switch to SettingsActivity
//                        Intent settingsIntent = new Intent(SettingsActivity.this, SettingsActivity.class);
//                        startActivity(settingsIntent);
//                        return true;
//
//                    default:
//                        return false;
//                }
//            }
//        });
    }
}