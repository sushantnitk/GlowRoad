package com.example.easysoft.glowapp;

import android.app.Application;

import com.bumptech.glide.request.target.ViewTarget;

/**
 * Created by YATRAONLINE\sushant.kumar on 24/8/18.
 */

public class App extends Application {
    @Override public void onCreate() {
        super.onCreate();
        ViewTarget.setTagId(R.id.glide_tag);
    }
}
