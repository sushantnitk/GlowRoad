package com.example.easysoft.glowapp.util;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.easysoft.glowapp.model.Project;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProjectRepository {
    private static ProjectRepository mInstance;
    private GLowRoadService gLowRoadService;
    private Retrofit retrofit;

    public ProjectRepository() {
         retrofit = new Retrofit.Builder()
                .baseUrl(GLowRoadService.HTTPS_FLICKR_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static synchronized ProjectRepository getInstance() {
        if (mInstance == null) {
            mInstance = new ProjectRepository();
        }
        return mInstance;
    }

    public GLowRoadService getApi() {
        return retrofit.create(GLowRoadService.class);
    }
}