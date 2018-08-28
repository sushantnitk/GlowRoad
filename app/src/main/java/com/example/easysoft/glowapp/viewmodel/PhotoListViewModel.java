package com.example.easysoft.glowapp.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PageKeyedDataSource;
import android.arch.paging.PagedList;

import com.example.easysoft.glowapp.data.ItemDataSource;
import com.example.easysoft.glowapp.data.ItemDataSourceFactory;
import com.example.easysoft.glowapp.model.PhotoList;

public class PhotoListViewModel extends ViewModel {
    public LiveData<PagedList<PhotoList>> itemPagedList;
    public LiveData<PageKeyedDataSource<Integer, PhotoList>> liveDataSource;


    public PhotoListViewModel() {
        //getting our data source factory
        ItemDataSourceFactory itemDataSourceFactory = new ItemDataSourceFactory();

        //getting the live data source from data source factory
        liveDataSource = itemDataSourceFactory.getItemLiveDataSource();

        //Getting PagedList config
        PagedList.Config pagedListConfig =
                (new PagedList.Config.Builder())
                        .setEnablePlaceholders(false)
                        .setPageSize(ItemDataSource.PAGE_SIZE).build();

        //Building the paged list
        itemPagedList = (new LivePagedListBuilder(itemDataSourceFactory, pagedListConfig))
                .build();
    }
}