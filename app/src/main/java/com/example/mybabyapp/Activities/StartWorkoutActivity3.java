package com.example.mybabyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mybabyapp.R;

import java.util.Locale;

public class StartWorkoutActivity3 extends AppCompatActivity {

    private static final long START_TIME_IN_MILLIS = 600000;
    private TextView mTxtCountdown;
    private Button mBtnStart;
    private Button mBtnReset;

    private CountDownTimer mcountDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_workout3);

        mTxtCountdown = findViewById(R.id.txt_countdown);
        mBtnStart = findViewById(R.id.btn_start);
        mBtnReset = findViewById(R.id.btn_reset);

        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mTimerRunning){
                    pauseTimer();
                }else{
                    startTimer();
                }
            }
        });

        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTimer();
            }
        });

        updateCountDownText();

    }

    private void startTimer() {
        mcountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long l) {
                mTimeLeftInMillis = l;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning= false;
                mBtnStart.setText("Start");
                mBtnStart.setVisibility(View.INVISIBLE);
                mBtnReset.setVisibility(View.VISIBLE);
            }
        }.start();

        mTimerRunning = true;
        mBtnStart.setText("pause");
        mBtnReset.setVisibility(View.VISIBLE);

    }

    private void pauseTimer() {
        mcountDownTimer.cancel();
        mTimerRunning = false;
        mBtnStart.setText("start");
        mBtnReset.setVisibility(View.VISIBLE);
    }

    private void resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        mBtnReset.setVisibility(View.INVISIBLE);
        mBtnStart.setVisibility(View.VISIBLE);
    }

    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);
        mTxtCountdown.setText(timeLeftFormatted);
    }
}