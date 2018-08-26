package com.example.easysoft.glowapp.view.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

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
            if (isNetworkAvailable()) {
                fm.beginTransaction().add(R.id.fragment_container, photoListFragment, PhotoListFragment.TAG).commit();
            } else {
                AlertDialog LDialog = new AlertDialog.Builder(this)
                        .setTitle("Network Blocked")
                        .setMessage("Network Blocked, Please check!!")
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        }).create();
                LDialog.show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
