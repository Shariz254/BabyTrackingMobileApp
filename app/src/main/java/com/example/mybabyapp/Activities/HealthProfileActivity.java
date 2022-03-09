package com.example.mybabyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mybabyapp.Adapters.HealthDataAdapter;
import com.example.mybabyapp.Adapters.ViewAppointmentAdapter;
import com.example.mybabyapp.DatabaseHelper;
import com.example.mybabyapp.Models.HealthDataModel;
import com.example.mybabyapp.R;

import java.util.ArrayList;

public class HealthProfileActivity extends AppCompatActivity {

    private EditText babyHeight, babyWeight;
    private Button save;
    DatabaseHelper sqLiteHelper;
    Activity act;
    Context context;

    ArrayList<HealthDataModel> healthDataList = new ArrayList<>();
    private RecyclerView healthRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_profile);

        context = this;
        act = this;
        sqLiteHelper = new DatabaseHelper(this);

        babyWeight = findViewById(R.id.babyWeight);
        babyHeight = findViewById(R.id.babyHeight);


        save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String mBabyHeight =  babyHeight.getText().toString().trim();
                String mBabyWeight =  babyWeight.getText().toString().trim();

                HealthDataModel hm = new HealthDataModel(mBabyHeight, mBabyWeight);

                if (hm.babyHeight == null){
                    babyHeight.setError("Required");
                    return;
                } else {
                    hm.setBabyHeight(mBabyHeight);
                    hm.setBabyWeight(mBabyWeight);
                    healthDataList.add(hm);

                    intUI();
                    sqLiteHelper.insertHealthData(mBabyWeight, mBabyHeight);
                    populate();
                }

                babyHeight.setText("");
                babyWeight.setText("");
            }
        });

        healthRecyclerView = findViewById(R.id.healthRecyclerView);

        intUI();
        populate();
    }

    void intUI() {
        healthRecyclerView = findViewById(R.id.healthRecyclerView);
    }

    void populate() {
        healthDataList = sqLiteHelper.loadHealthData();
        healthRecyclerView.setAdapter(new HealthDataAdapter(healthDataList));
        healthRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }
}