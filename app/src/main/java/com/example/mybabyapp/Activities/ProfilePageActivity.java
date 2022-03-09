package com.example.mybabyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mybabyapp.DatabaseHelper;
import com.example.mybabyapp.Models.ProfileModel;
import com.example.mybabyapp.R;
import com.google.android.material.textfield.TextInputEditText;

public class ProfilePageActivity extends AppCompatActivity {

    private TextInputEditText childName, childDob, gender;
    private Button btnCreateProfile;
    private TextView cancel;
    SQLiteDatabase sd;
    DatabaseHelper sqLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        childName = findViewById(R.id.childName);
        childDob = findViewById(R.id.childDob);
        gender = findViewById(R.id.gender);
        btnCreateProfile = findViewById(R.id.btnCreateProfile);
        cancel = findViewById(R.id.cancel);

        DatabaseHelper sqLiteHelper = new DatabaseHelper(ProfilePageActivity.this);

        btnCreateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String babyNameEDT = childName.getText().toString().trim();
                String babyDobEDT = childDob.getText().toString().trim();
                String babyGenderEDT = gender.getText().toString().trim();

//                if (babyNameEDT.isEmpty()){
//                    Toast.makeText(ProfilePageActivity.this, "All Fields are required", Toast.LENGTH_SHORT).show();
//                } else {
                    Intent intent = new Intent(ProfilePageActivity.this, DashboardActivity.class);
                    //sqLiteHelper.insertProfile(babyNameEDT, babyDobEDT, babyGenderEDT);
                    startActivity(intent);

                    Log.e("lll", "onCreate: " +childName);
                //}

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfilePageActivity.this, SplashScreenActivity.class);
                startActivity(intent);
                //finish();
            }
        });

    }
}