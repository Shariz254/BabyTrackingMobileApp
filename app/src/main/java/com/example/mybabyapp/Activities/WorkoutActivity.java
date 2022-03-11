package com.example.mybabyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import com.example.mybabyapp.R;

public class WorkoutActivity extends AppCompatActivity {

    private Button startWorkout1, startWorkout2, startWorkout3, startWorkout4, startWorkout5;
    private LinearLayout foodNutrition;

    private androidx.appcompat.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        //toolbar back arrow
        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        //toolbar back arrow end

        startWorkout1 = findViewById(R.id.startWorkout1);
        startWorkout2 = findViewById(R.id.startWorkout2);
        startWorkout3 = findViewById(R.id.startWorkout3);
        startWorkout4 = findViewById(R.id.startWorkout4);
        startWorkout5 = findViewById(R.id.startWorkout5);
        foodNutrition = findViewById(R.id.foodNutrition);


        startWorkout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutActivity.this, StartWorkoutActivity.class);
                startActivity(intent);
            }
        });
        startWorkout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutActivity.this, StartWorkoutActivity2.class);
                startActivity(intent);
            }
        });
        startWorkout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutActivity.this, StartWorkoutActivity3.class);
                startActivity(intent);
            }
        });
        startWorkout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutActivity.this, StartWorkoutActivity4.class);
                startActivity(intent);
            }
        });
        startWorkout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutActivity.this, StartWorkoutActivity5.class);
                startActivity(intent);
            }
        });

        foodNutrition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutActivity.this, NutritionActivity.class);
                startActivity(intent);
            }
        });

    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

    public void food(View view) {
        Intent intent = new Intent(WorkoutActivity.this, NutritionActivity.class);
        startActivity(intent);
    }
}