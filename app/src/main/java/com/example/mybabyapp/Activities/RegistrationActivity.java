package com.example.mybabyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mybabyapp.DatabaseHelper;
import com.example.mybabyapp.R;

public class RegistrationActivity extends AppCompatActivity {

    private Button btnRegister;
    private EditText email, username, password;
    DatabaseHelper sqLiteHelper;
    Context context;
    Activity act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        context = this;
        act = this;
        sqLiteHelper = new DatabaseHelper(this);

        email = findViewById(R.id.email);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mEmail = email.getText().toString().trim();
                String mUsername = username.getText().toString().trim();
                String mPassword = password.getText().toString().trim();

                if (mUsername.isEmpty()){
                    Toast.makeText(act, "All fields are Required", Toast.LENGTH_SHORT).show();
                } else{
                    Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                    sqLiteHelper.insertRegistration(mEmail ,mUsername, mPassword);
                    startActivity(intent);
                }

            }
        });

    }
}