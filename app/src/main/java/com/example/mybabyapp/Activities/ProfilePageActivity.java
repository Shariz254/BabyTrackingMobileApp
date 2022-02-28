package com.example.mybabyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mybabyapp.R;
import com.google.android.material.textfield.TextInputEditText;

public class ProfilePageActivity extends AppCompatActivity {

    private TextInputEditText childName, childDob, gender;
    private Button btnCreateProfile;
    private TextView cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        childName = findViewById(R.id.childName);
        childDob = findViewById(R.id.childDob);
        gender = findViewById(R.id.gender);
        btnCreateProfile = findViewById(R.id.btnCreateProfile);
        cancel = findViewById(R.id.cancel);

        btnCreateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfilePageActivity.this, DashboardActivity.class);
                startActivity(intent);
                //finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfilePageActivity.this, DashboardActivity.class);
                startActivity(intent);
                //finish();
            }
        });

    }
}