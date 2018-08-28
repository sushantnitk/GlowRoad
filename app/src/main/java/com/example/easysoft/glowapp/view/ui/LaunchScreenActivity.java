package com.example.easysoft.glowapp.view.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class LaunchScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent =new Intent(LaunchScreenActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

}