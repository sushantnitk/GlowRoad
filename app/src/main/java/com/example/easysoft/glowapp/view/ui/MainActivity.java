package com.example.easysoft.glowapp.view.ui;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

import com.example.easysoft.glowapp.R;

public class MainActivity extends AppCompatActivity {

    private PhotoListFragment photoListFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        photoListFragment = (PhotoListFragment) fm.findFragmentByTag(PhotoListFragment.TAG);
        if (photoListFragment == null) {
            photoListFragment = new PhotoListFragment();
            fm.beginTransaction().add(R.id.fragment_container,photoListFragment, PhotoListFragment.TAG).commit();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
