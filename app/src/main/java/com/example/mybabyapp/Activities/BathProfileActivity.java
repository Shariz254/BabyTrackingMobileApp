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
import android.widget.Button;
import android.widget.EditText;

import com.example.mybabyapp.Adapters.BathAdapter;
import com.example.mybabyapp.Adapters.DaiperAdapter;
import com.example.mybabyapp.DatabaseHelper;
import com.example.mybabyapp.Models.BathModel;
import com.example.mybabyapp.R;

import java.util.ArrayList;

public class BathProfileActivity extends AppCompatActivity {

    private RecyclerView bathRecyclerView;
    private Button btnBath;
    Context context;
    Activity act;
    private ArrayList<BathModel> Bdata = new ArrayList<>();
    private DatabaseHelper sqliteHelper;
    private Toolbar toolbar;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bath_profile);

        context = this;
        act = this;
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

        bathRecyclerView = findViewById(R.id.bathRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        bathRecyclerView.setHasFixedSize(true);
        bathRecyclerView.setLayoutManager(linearLayoutManager);

        btnBath = findViewById(R.id.btnBath);
        btnBath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bathDialog();
            }
        });

        intUI();
        populate();
    }

    void intUI() {
        bathRecyclerView = findViewById(R.id.bathRecyclerView);
    }

    void populate() {
        Bdata = sqliteHelper.loadBathData();
        bathRecyclerView.setAdapter(new BathAdapter(Bdata));
        bathRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }

    private void bathDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.add_bath_dialog, null);
        alertDialog.setView(view);
        final AlertDialog myDialog = alertDialog.create();

        final EditText mBathTime = view.findViewById(R.id.bathTime);
        final EditText mBathDay = view.findViewById(R.id.bathDay);

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
                String bathTime = mBathTime.getText().toString().trim();
                String bathDay = mBathDay.getText().toString().trim();

                BathModel bm = new BathModel(bathTime, bathDay);
                if (bm.bathTime == null){
                    mBathTime.setError("Required");
                    return;
                }else{
                    bm.setBathTime(bathTime);
                    bm.setBathDay(bathDay);
                    Bdata.add(bm);

                    intUI();
                    sqliteHelper.insertBath(bathTime, bathDay);
                    populate();

                }
                myDialog.dismiss();
            }
        });
        myDialog.show();
    }
}