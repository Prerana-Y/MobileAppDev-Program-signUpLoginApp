package com.example.signuploginapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText etLoginUsername, etLoginPassword;
    Button btnLogin;
    int attempts = 2;
    String correctUsername, correctPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLoginUsername = findViewById(R.id.etLoginUsername);
        etLoginPassword = findViewById(R.id.etLoginPassword);
        btnLogin = findViewById(R.id.btnLogin);

        correctUsername = getIntent().getStringExtra("USERNAME");
        correctPassword = getIntent().getStringExtra("PASSWORD");

        btnLogin.setOnClickListener(v -> {
            String enteredUsername = etLoginUsername.getText().toString();
            String enteredPassword = etLoginPassword.getText().toString();

            if (enteredUsername.equals(correctUsername) && enteredPassword.equals(correctPassword)) {
                startActivity(new Intent(LoginActivity.this, SuccessActivity.class));
            } else {
                attempts--;
                if (attempts > 0) {
                    Toast.makeText(this, "Login Failed. Attempts left: " + attempts, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Failed Login Attempts", Toast.LENGTH_LONG).show();
                    btnLogin.setEnabled(false);
                }
            }
        });
    }
}
