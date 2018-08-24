package com.example.easysoft.glowapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by YATRAONLINE\sushant.kumar on 23/8/18.
 */

public class Project {
    @SerializedName("photo")
    private List<PhotoList> photoList;

    public List<PhotoList> getPhotoList() {
        return photoList;
    }

}
