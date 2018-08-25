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
    private GLowRoadService gLowRoadService;

    public ProjectRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GLowRoadService.HTTPS_FLICKR_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        gLowRoadService = retrofit.create(GLowRoadService.class);
    }



    public LiveData<Project> getProjectList() {
        final MutableLiveData<Project> data = new MutableLiveData<>();

        gLowRoadService.getPhotoList().enqueue(new Callback<Project>() {
            @Override
            public void onResponse(Call<Project> call, Response<Project> response) {
                data.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Project> call, Throwable t) {
                // TODO better error handling in part #2 ...
                data.postValue(null);
            }
        });

        return data;
    }
}