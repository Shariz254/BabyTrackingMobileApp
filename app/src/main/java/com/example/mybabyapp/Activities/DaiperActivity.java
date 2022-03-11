package com.example.mybabyapp.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.mybabyapp.Adapters.DaiperAdapter;
import com.example.mybabyapp.Adapters.FeedingAdapter;
import com.example.mybabyapp.DatabaseHelper;
import com.example.mybabyapp.Models.DaiperModel;
import com.example.mybabyapp.Models.FeedingModel;
import com.example.mybabyapp.R;

import java.util.ArrayList;

public class DaiperActivity extends AppCompatActivity {

    private Button btnChangeDaiper;
    private RecyclerView daiperRecyclerView;
    ArrayList<DaiperModel> Mdata = new ArrayList<>();
    private DatabaseHelper sqliteHelper;
    Activity activity;
    Context context;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daiper);
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

        daiperRecyclerView = findViewById(R.id.daiperRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        daiperRecyclerView.setHasFixedSize(true);
        daiperRecyclerView.setLayoutManager(linearLayoutManager);

        btnChangeDaiper = findViewById(R.id.btnChangeDaiper);
        btnChangeDaiper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addDaiperChangeTime();
            }
        });

        intUI();
        populate();
    }


    void intUI() {
        daiperRecyclerView = findViewById(R.id.daiperRecyclerView);
    }

    void populate() {
        Mdata = sqliteHelper.loadDaiperData();
        daiperRecyclerView.setAdapter(new DaiperAdapter(Mdata));
        daiperRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }

    private void addDaiperChangeTime() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.add_daiper_time_dialog, null);
        dialog.setView(view);
        final AlertDialog myDialog = dialog.create();

        final EditText daiperChangeTime = view.findViewById(R.id.daiperChangeTime);
        final EditText daiperChangeDay = view.findViewById(R.id.daiperChangeDay);

        Button btnSave = view.findViewById(R.id.btnSave);
        Button btnCancel = view.findViewById(R.id.btnCancel);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mChangeTime = daiperChangeTime.getText().toString().trim();
                String mChangeDay = daiperChangeDay.getText().toString().trim();

                DaiperModel dm = new DaiperModel(mChangeTime, mChangeDay);

                if (dm.change_time == null){
                    daiperChangeTime.setError("Required");
                    return;
                }else{
                    dm.setChange_time(mChangeTime);
                    dm.setChangeDay(mChangeDay);
                    Mdata.add(dm);

                    intUI();
                    sqliteHelper.insertDaiper(mChangeTime, mChangeDay);
                    populate();
                }
                myDialog.dismiss();
            }
        });
        myDialog.show();
    }

}