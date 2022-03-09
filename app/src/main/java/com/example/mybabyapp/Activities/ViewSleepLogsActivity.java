package com.example.mybabyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.mybabyapp.Adapters.DaiperAdapter;
import com.example.mybabyapp.Adapters.SleepAdapter;
import com.example.mybabyapp.DatabaseHelper;
import com.example.mybabyapp.Models.DaiperModel;
import com.example.mybabyapp.Models.SleepModel;
import com.example.mybabyapp.R;

import java.util.ArrayList;

public class ViewSleepLogsActivity extends AppCompatActivity {

    private RecyclerView sleepRecyclerView;
    ArrayList<SleepModel> SleepData = new ArrayList<>();
    DatabaseHelper sqliteHelper;
    Activity act;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_sleep_logs);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        sleepRecyclerView = findViewById(R.id.sleepRecyclerView);
        context = this;
        act = this;
        sqliteHelper = new DatabaseHelper(this);


        intUI();
        populate();
    }

    void intUI() {
        sleepRecyclerView = findViewById(R.id.sleepRecyclerView);
    }

    void populate() {
        SleepData = sqliteHelper.loadSleepData();
        sleepRecyclerView.setAdapter(new SleepAdapter(SleepData));
        sleepRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }

}