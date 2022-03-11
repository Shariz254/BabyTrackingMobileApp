package com.example.mybabyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mybabyapp.R;

public class SleepActivity extends AppCompatActivity {

    private Button logSleepBtn, viewSleepSchedule, bedTimeStory;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);

        //toolbar back arrow
        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        //toolbar back arrow end

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