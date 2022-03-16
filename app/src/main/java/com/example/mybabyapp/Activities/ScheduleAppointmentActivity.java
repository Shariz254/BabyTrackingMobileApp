package com.example.mybabyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mybabyapp.DatabaseHelper;
import com.example.mybabyapp.R;

public class ScheduleAppointmentActivity extends AppCompatActivity {

    private Button scheduleAppointmentBtn;
    private EditText babyName, babyAge, babySymptoms, timeFrom, dayFrom;
    DatabaseHelper sqLiteHelper;
    Context context;
    Activity act;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_appointment);

        context = this;
        act = this;
        sqLiteHelper = new DatabaseHelper(this);

        //toolbar back arrow
        toolbar = findViewById(R.id.toolbar);
        //toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        //toolbar back arrow end

        babyName = findViewById(R.id.babyName);
        babyAge = findViewById(R.id.babyAge);
        babySymptoms = findViewById(R.id.babySymptoms);
        timeFrom = findViewById(R.id.timeFrom);
        dayFrom = findViewById(R.id.dayFrom);

        scheduleAppointmentBtn = findViewById(R.id.scheduleAppointmentBtn);
        scheduleAppointmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String babyNameEDT = babyName.getText().toString().trim();
                String babyAgeEDT = babyAge.getText().toString().trim();
                String babySymptomsEDT = babySymptoms.getText().toString().trim();
                String timeFromEDT = timeFrom.getText().toString().trim();
                String dayFromEDT = dayFrom.getText().toString().trim();

                if (babyNameEDT.isEmpty()){
                    Toast.makeText(act, "All Fields are required", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(ScheduleAppointmentActivity.this, MedicalActivity.class);
                    sqLiteHelper.insertMedicalAppointment(babyNameEDT,babyAgeEDT,babySymptomsEDT,timeFromEDT,dayFromEDT);
                    Toast.makeText(act, "Appointment Sceduled", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }
        });
    }
}