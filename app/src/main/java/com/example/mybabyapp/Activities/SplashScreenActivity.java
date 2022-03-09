package com.example.mybabyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mybabyapp.DatabaseHelper;
import com.example.mybabyapp.R;

public class SplashScreenActivity extends AppCompatActivity {

    private ImageView logo;
    private TextView title;
    private Button btnGetStarted;
    SQLiteDatabase sd;
    DatabaseHelper sqLiteHelper;
    Activity act;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        context =this;
        act=this;
        //to launch db
        sqLiteHelper = new DatabaseHelper(act);
        sd = sqLiteHelper.openDatabase();

        logo = findViewById(R.id.logo);
        title = findViewById(R.id.title);
        btnGetStarted = findViewById(R.id.btnGetStarted);
        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}