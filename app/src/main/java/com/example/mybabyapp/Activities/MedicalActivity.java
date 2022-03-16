package com.example.mybabyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mybabyapp.R;

public class MedicalActivity extends AppCompatActivity {

    private Button healthProfile, scheduleAppointment, viewAppoinmtemt;
    private Toolbar toolbar;
    private TextView cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical);

        healthProfile = findViewById(R.id.healthProfile);
        scheduleAppointment = findViewById(R.id.scheduleAppointment);
        viewAppoinmtemt = findViewById(R.id.viewAppoinmtemt);

        //toolbar back arrow
        toolbar = findViewById(R.id.toolbar);
        //toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //onBackPressed();
            }
        });
        //toolbar back arrow end

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

        cancel = findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MedicalActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });

    }
}