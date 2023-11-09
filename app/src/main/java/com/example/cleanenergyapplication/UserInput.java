package com.example.cleanenergyapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UserInput extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_input);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        // Switch to ZoneActivity
                        Intent homeIntent = new Intent(UserInput.this,ZoneScreen.class);
                        startActivity(homeIntent);
                        return true;

                    case R.id.input:
                        // Switch to MainActivity
                        Intent inputIntent = new Intent(UserInput.this, MainActivity.class);
                        startActivity(inputIntent);
                        return true;

                    case R.id.settings:
                        // Switch to SettingsActivity
                        Intent settingsIntent = new Intent(UserInput.this, SettingsActivity.class);
                        startActivity(settingsIntent);
                        return true;

                    default:
                        return false;
                }
            }
        });

    Button submitButton = findViewById(R.id.submitButton);
    final EditText editText1 = findViewById(R.id.editText1);
    final EditText editText2 = findViewById(R.id.editText2);

        submitButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String input1 = editText1.getText().toString().trim();
            String input2 = editText2.getText().toString().trim();

            // Retrieve the values from the EditText fields
            double value1 = Double.parseDouble(editText1.getText().toString());
            double value2 = Double.parseDouble(editText2.getText().toString());

            if (input1.isEmpty() || input2.isEmpty()) {
                // Display a toast message indicating that both fields must be filled
                Toast.makeText(UserInput.this, "Please fill out both fields", Toast.LENGTH_SHORT).show();
            } else {
                // Both fields are filled, navigate to MainActivity
                Intent intent = new Intent(UserInput.this, MainActivity.class);

                // Pass the values as extras
                intent.putExtra("value1", value1);
                intent.putExtra("value2", value2);

                startActivity(intent);

            }
        }
        });


        ImageButton infoButton = findViewById(R.id.infoButton);

        // Set an OnClickListener for the info button
        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a dialog to display the information
                Dialog dialog = new Dialog(UserInput.this);
                dialog.setContentView(R.layout.popup_info);
                dialog.show();
            }
        });
}
}