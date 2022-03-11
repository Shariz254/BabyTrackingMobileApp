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
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_profile);

        context =this;
        act=this;

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