package com.example.easysoft.glowapp.data;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;
import android.arch.paging.PageKeyedDataSource;

import com.example.easysoft.glowapp.model.PhotoList;

public class ItemDataSourceFactory extends DataSource.Factory {
 
    //creating the mutable live data
    private MutableLiveData<PageKeyedDataSource<Integer, PhotoList>> itemLiveDataSource = new MutableLiveData<>();
 
    @Override
    public DataSource<Integer, PhotoList> create() {
        //getting our data source object
        ItemDataSource itemDataSource = new ItemDataSource();
 
        //posting the datasource to get the values
        itemLiveDataSource.postValue(itemDataSource);
        
        //returning the datasource
        return itemDataSource;
    }
 
    
    //getter for itemlivedatasource
    public MutableLiveData<PageKeyedDataSource<Integer, PhotoList>> getItemLiveDataSource() {
        return itemLiveDataSource;
    }
}