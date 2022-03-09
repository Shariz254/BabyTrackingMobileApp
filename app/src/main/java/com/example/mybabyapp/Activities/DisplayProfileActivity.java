package com.example.mybabyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.mybabyapp.Adapters.ProfileAdapter;
import com.example.mybabyapp.DatabaseHelper;
import com.example.mybabyapp.Models.ProfileModel;
import com.example.mybabyapp.R;

import java.util.ArrayList;

public class DisplayProfileActivity extends AppCompatActivity {

    private RecyclerView childProfileRecyclerView;

    DatabaseHelper sqLiteHelper;
    Activity act;
    Context context;

    ArrayList<ProfileModel> profileData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_profile);


        context =this;
        act=this;

        childProfileRecyclerView = findViewById(R.id.childProfileRecyclerView);
        sqLiteHelper = new DatabaseHelper(this);

        intUI();
        populate();

    }

    void intUI() {
        childProfileRecyclerView = findViewById(R.id.childProfileRecyclerView);
    }

    void populate() {
        profileData = sqLiteHelper.loadProfileDetails();
        childProfileRecyclerView.setAdapter(new ProfileAdapter(profileData));
        childProfileRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }
}