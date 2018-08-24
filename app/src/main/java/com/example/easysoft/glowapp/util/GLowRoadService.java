package com.example.easysoft.glowapp.util;

import com.example.easysoft.glowapp.model.Project;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by YATRAONLINE\sushant.kumar on 23/8/18.
 */

public interface GLowRoadService {
    String HTTPS_FLICKR_BASE_URL = "https://api.flickr.com/";
    String API_KEY = "641c87bd78e54920b01e9a5d8bb726d7";


    @GET("services/rest/?method=flickr.photos.search&api_key=641c87bd78e54920b01e9a5d8bb726d7&format=json&nojsoncallback=1&text=shirts&extras=url_q")
    Call<Project> getPhotoList();

}
