package com.example.edu.mystopwatch;

import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    Button start,pause,reset,savelab;
    Handler handler = new Handler();
    TextView textView;
    int milliseconds,minutes,seconds;
    long startTime,timeBuff=0l,millisecondTime,updateTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.btnstart);
        start.setOnClickListener(this);
        pause = findViewById(R.id.btnpause);
        pause.setOnClickListener(this);
        reset = findViewById(R.id.btnreset);
        reset.setOnClickListener(this);
        savelab = findViewById(R.id.btnsavelab);
        savelab.setOnClickListener(this);
        textView = findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnstart:
                startTime = SystemClock.uptimeMillis();
                handler.postDelayed(runnable,0);
                break;
            case R.id.btnpause:
                timeBuff += millisecondTime;
                handler.removeCallbacks(runnable);
                break;
        }}

        public Runnable runnable= new Runnable() {
            @Override
            public void run() {
                millisecondTime = SystemClock.uptimeMillis() - startTime;
                updateTime = timeBuff + millisecondTime;
                seconds = (int) (updateTime / 1000);
                minutes = seconds / 60;
                seconds = seconds % 60;
                milliseconds = (int) (updateTime % 1000);
                textView.setText(minutes + ":" + String.format("%02d", seconds) + ":" + String.format("%03d", milliseconds));
                handler.postDelayed(this,0);
            }
        };
    }

