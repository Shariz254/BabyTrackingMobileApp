package com.example.mybabyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mybabyapp.R;

public class BedtimeStoryActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Button story1, story2, story3, story4;
    private TextView cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bedtime_story);

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

        story1 = findViewById(R.id.story1);
        story1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BedtimeStoryActivity.this, Story1Activity.class);
                startActivity(intent);
            }
        });

        story2 = findViewById(R.id.story2);
        story2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BedtimeStoryActivity.this, Story2Activity.class);
                startActivity(intent);
            }
        });

        story3 = findViewById(R.id.story3);
        story3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BedtimeStoryActivity.this, Story3Activity.class);
                startActivity(intent);
            }
        });

        story4 = findViewById(R.id.story4);
        story4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BedtimeStoryActivity.this, Story4Activity.class);
                startActivity(intent);
            }
        });


        cancel = findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BedtimeStoryActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });
    }
}