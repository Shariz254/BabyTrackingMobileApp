package com.example.mybabyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mybabyapp.R;

public class MedicalActivity extends AppCompatActivity {

    private Button healthProfile, scheduleAppointment, viewAppoinmtemt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical);

        healthProfile = findViewById(R.id.healthProfile);
        scheduleAppointment = findViewById(R.id.scheduleAppointment);
        viewAppoinmtemt = findViewById(R.id.viewAppoinmtemt);

        healthProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MedicalActivity.this, HealthProfileActivity.class);
                startActivity(intent);
            }
        });

        scheduleAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MedicalActivity.this, ScheduleAppointmentActivity.class);
                startActivity(intent);
            }
        });

        viewAppoinmtemt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MedicalActivity.this, ViewAppointmentActivity.class);
                startActivity(intent);
            }
        });
    }
}