package com.example.mybabyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mybabyapp.R;

public class SleepActivity extends AppCompatActivity {

    private Button logSleepBtn, viewSleepSchedule, bedTimeStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);

        logSleepBtn = findViewById(R.id.logSleepBtn);
        viewSleepSchedule = findViewById(R.id.viewSleepSchedule);
        bedTimeStory = findViewById(R.id.bedTimeStory);

        logSleepBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SleepActivity.this, LogSleepActivity.class);
                startActivity(intent);
            }
        });

        viewSleepSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SleepActivity.this, ViewSleepLogsActivity.class);
                startActivity(intent);
            }
        });

        bedTimeStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SleepActivity.this, BedtimeStoryActivity.class);
                startActivity(intent);
            }
        });
    }
}