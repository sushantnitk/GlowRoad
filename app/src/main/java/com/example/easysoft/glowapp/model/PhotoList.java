package com.example.easysoft.glowapp.model;


import com.google.gson.annotations.SerializedName;

/**
 * Created by YATRAONLINE\sushant.kumar on 23/8/18.
 */

public class PhotoList {
    @SerializedName("title")
    private String title;
    @SerializedName("url_q")
    private String imageUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
