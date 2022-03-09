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

public class LogSleepActivity extends AppCompatActivity {

    private EditText timeFrom, timeTo;
    private Button saveSleepBtn;
    DatabaseHelper sqLiteHelper;
    Context context;
    Activity act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_sleep);

        context = this;
        act = this;
        sqLiteHelper = new DatabaseHelper(this);


        timeFrom = findViewById(R.id.timeFrom);
        timeTo = findViewById(R.id.timeTo);

        saveSleepBtn = findViewById(R.id.saveSleepBtn);
        saveSleepBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sleepTimeEDT = timeFrom.getText().toString().trim();
                String wakeUpTimeEDT = timeTo.getText().toString().trim();

                if (sleepTimeEDT.isEmpty()){
                    Toast.makeText(act, "All Fields are required", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(LogSleepActivity.this, SleepActivity.class);
                    sqLiteHelper.insertSleepData(sleepTimeEDT, wakeUpTimeEDT);
                    startActivity(intent);
                }

            }
        });
    }
}