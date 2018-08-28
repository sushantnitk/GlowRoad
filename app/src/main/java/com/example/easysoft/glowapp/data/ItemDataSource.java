package com.example.easysoft.glowapp.data;

import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.easysoft.glowapp.model.PhotoList;
import com.example.easysoft.glowapp.model.Project;
import com.example.easysoft.glowapp.util.ProjectRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemDataSource extends PageKeyedDataSource<Integer, PhotoList> {
 
    //the size of a page that we want
    public static final int PAGE_SIZE = 50;
 
    //we will start from the first page which is 1
    private static final int FIRST_PAGE = 1;
 
 
    //this will be called once to load the initial data
    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, PhotoList> callback) {
        ProjectRepository.getInstance()
                .getApi().getPhotoList(FIRST_PAGE, PAGE_SIZE)
                .enqueue(new Callback<Project>() {
                    @Override
                    public void onResponse(Call<Project> call, Response<Project> response) {
                        Log.d("Url Initial", response.raw().request().url().toString());
                        if (response.body() != null) {
                            callback.onResult(response.body().getPhotos().getPhotoList(), null, FIRST_PAGE + 1);
                        }
                    }
 
                    @Override
                    public void onFailure(Call<Project> call, Throwable t) {
 
                    }
                });
    }
 
    //this will load the previous page
    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, PhotoList> callback) {
        ProjectRepository.getInstance()
                .getApi().getPhotoList(params.key, PAGE_SIZE)
                .enqueue(new Callback<Project>() {
                    @Override
                    public void onResponse(Call<Project> call, Response<Project> response) {
                        Log.d("Url Before", response.raw().request().url().toString());
                        //if the current page is greater than one
                        //we are decrementing the page number
                        //else there is no previous page
                        Integer adjacentKey = (params.key > 1) ? params.key - 1 : null;
                        if (response.body() != null) {
 
                            //passing the loaded data
                            //and the previous page key 
                            callback.onResult(response.body().getPhotos().getPhotoList(), adjacentKey);
                        }
                    }
 
                    @Override
                    public void onFailure(Call<Project> call, Throwable t) {
 
                    }
                });
    }
 
    //this will load the next page
    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, PhotoList> callback) {
        ProjectRepository.getInstance()
                .getApi()
                .getPhotoList(params.key, PAGE_SIZE)
                .enqueue(new Callback<Project>() {
                    @Override
                    public void onResponse(Call<Project> call, Response<Project> response) {
                        Log.d("Url After", response.raw().request().url().toString());
                        
                        if (response.body() != null) {
                            //if the response has next page
                            //incrementing the next page number
                            Integer key =  params.key + 1;
                            /*if(response.body().getTotalPages() > params.key){
                                key =  params.key + 1;
                            }*/
                            //passing the loaded data and next page value 
                            callback.onResult(response.body().getPhotos().getPhotoList(), key);
                        }
                    }
 
                    @Override
                    public void onFailure(Call<Project> call, Throwable t) {
 
                    }
                });
    }
}