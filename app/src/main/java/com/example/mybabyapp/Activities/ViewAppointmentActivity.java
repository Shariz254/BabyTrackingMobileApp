package com.example.mybabyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.example.mybabyapp.Adapters.ProfileAdapter;
import com.example.mybabyapp.Adapters.ViewAppointmentAdapter;
import com.example.mybabyapp.DatabaseHelper;
import com.example.mybabyapp.Models.ScheduleAppointmentModel;
import com.example.mybabyapp.R;

import java.util.ArrayList;

public class ViewAppointmentActivity extends AppCompatActivity {

    DatabaseHelper sqLiteHelper;
    Activity act;
    Context context;
    private Toolbar toolbar;

    private RecyclerView medicalRecyclerView;
    ArrayList<ScheduleAppointmentModel> viewAppointment = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_appointment);

        context =this;
        act=this;
        sqLiteHelper = new DatabaseHelper(this);

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

        medicalRecyclerView = findViewById(R.id.medicalRecyclerView);
        intUI();
        populate();
    }

    void intUI() {
        medicalRecyclerView = findViewById(R.id.medicalRecyclerView);
    }

    void populate() {
        viewAppointment = sqLiteHelper.loadAppointments();
        medicalRecyclerView.setAdapter(new ViewAppointmentAdapter(viewAppointment));
        medicalRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }
}