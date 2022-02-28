package com.example.mybabyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.mybabyapp.R;

public class DashboardActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private LinearLayout feeding, daiper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("BABY APP");

        feeding = findViewById(R.id.feeding);
        feeding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, FeedingActivity.class);
                startActivity(intent);
            }
        });

        daiper = findViewById(R.id.daiper);
        daiper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, DaiperActivity.class);
                startActivity(intent);
            }
        });

    }
}