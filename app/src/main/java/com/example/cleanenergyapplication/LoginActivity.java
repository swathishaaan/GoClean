package com.example.cleanenergyapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {
    //private FirebaseAuth mAuth;
    private EditText etEmail;
    private EditText etPassword;
    private Button btnLogin;

    private TextView tvSignUp;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //mAuth = FirebaseAuth.getInstance();
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        btnLogin= findViewById(R.id.btnLogIn);
        tvSignUp = findViewById(R.id.tvSignUp);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                if(email.isEmpty()) {
                    etEmail.setError("Please provide your email address");
                } else if (password.isEmpty()) {
                    etPassword.setError("Please provide a password email address");
                } else if(!(email.equals("marc12@gmail.com"))) {
                    etEmail.setError("Invalid email address");
                } else if (!(password.equals("saveMoney124"))) {
                    etPassword.setError("Invalid password");
                } else {
                    login();
                }
            }
        });

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchToSignUp();
            }
        });
    }
        private void login() {
            Intent intent = new Intent(LoginActivity.this, UserInput.class);
            startActivity(intent);
        }

        private void launchToSignUp() {
            Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(intent);

        }
}