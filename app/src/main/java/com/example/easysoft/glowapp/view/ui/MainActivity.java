package com.example.easysoft.glowapp.view.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.easysoft.glowapp.R;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PhotoListFragment photoListFragment = new PhotoListFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, photoListFragment, PhotoListFragment.TAG).commit();
    }
}
