package com.example.mybabyapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mybabyapp.Adapters.FeedingAdapter;
import com.example.mybabyapp.DatabaseHelper;
import com.example.mybabyapp.Models.FeedingModel;
import com.example.mybabyapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FeedingActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private FloatingActionButton floatingActionButton;
    private DatabaseHelper sqliteHelper;
    Activity activity;
    Context context;

    ArrayList<FeedingModel> Tdata = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeding);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        activity=this;
        context=this;
        sqliteHelper = new DatabaseHelper(this);

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

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFeeding();
            }
        });

        intUI();
        populate();
    }

    void intUI(){
        recyclerView = findViewById(R.id.recyclerView);
    }

    void populate(){
        Tdata = sqliteHelper.loadFeedingData();
        recyclerView.setAdapter(new FeedingAdapter(Tdata));
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }

    //METHOD TO ADD FEEDING DATA
    private void addFeeding() {
        AlertDialog.Builder myDialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = LayoutInflater.from(this);

        View myView = inflater.inflate(R.layout.feeding_input_file, null);
        myDialog.setView(myView);

        final AlertDialog dialog = myDialog.create();
        dialog.setCancelable(false);

        final EditText feedingTime = myView.findViewById(R.id.feedingTime);
        final EditText foodType = myView.findViewById(R.id.foodType);
        final EditText foodQuantity = myView.findViewById(R.id.foodQuantity);

        Button btnSave = myView.findViewById(R.id.btnSave);
        Button btnCancel = myView.findViewById(R.id.btnCancel);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mfeedingTime = feedingTime.getText().toString().trim();
                String mfoodType = foodType.getText().toString().trim();
                String mfoodQuantity = foodQuantity.getText().toString().trim();

                FeedingModel data = new FeedingModel(mfeedingTime, mfoodType, mfoodQuantity);

                    if (data.feeding_Time==null||data.food_Type.length()<1)
                    {
                        feedingTime.setError("Time Required");
                        return;
                    } else {
                        data.setFeeding_Time(mfeedingTime);
                        data.setFood_Type(mfoodType);
                        data.setFood_Quantity(mfoodQuantity);
                        Tdata.add(data);

                        Log.e("Name=>", "Food Type name=>"+mfoodType);

                        intUI();
                        sqliteHelper.insertFeeding(mfeedingTime,mfoodType,mfoodQuantity);
                        populate();
                    }
                    dialog.dismiss();
                }
        });

        dialog.show();
    }
}