package com.example.easysoft.glowapp.view.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.example.easysoft.glowapp.R;

import java.util.Timer;
import java.util.TimerTask;

public class LaunchScreenActivity extends AppCompatActivity {

    private static final int SPLASH_TIME = 3000;

    private Timer timer;
    private ProgressBar progressBar;
    private int i=0;
    TextView textView,progressText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        progressBar=findViewById(R.id.progressBar);
        progressBar.setProgress(0);
        textView=findViewById(R.id.textView);
        progressText = findViewById(R.id.tv_progress);

        RunAnimation();
        showProgressBar();
    }

    private void showProgressBar() {
        final long period = 100;
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //this repeats every 100 ms
                if (i<100){
                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            progressText.setText(String.valueOf(i)+"%");
                        }
                    });
                    progressBar.setProgress(i);
                    i+=3;
                }else{
                    //closing the timer
                    timer.cancel();
                    Intent intent =new Intent(LaunchScreenActivity.this,MainActivity.class);
                    startActivity(intent);
                    // close this activity
                    finish();
                }
            }
        }, 0, period);
    }

    private void RunAnimation()
    {
        Animation a = AnimationUtils.loadAnimation(this, R.anim.textanim);
        a.reset();
        textView.clearAnimation();
        textView.startAnimation(a);
    }
}