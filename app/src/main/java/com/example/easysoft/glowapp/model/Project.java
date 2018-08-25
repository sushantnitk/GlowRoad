package com.example.easysoft.glowapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YATRAONLINE\sushant.kumar on 23/8/18.
 */
public class Project {
    @SerializedName("photos")
    private PhotoClass photos;

    public PhotoClass getPhotos() {
        return photos;
    }

    public class PhotoClass {
        @SerializedName("photo")
        private ArrayList<PhotoList> photoList;


        public ArrayList<PhotoList> getPhotoList() {

            return photoList;
        }
    }
}
