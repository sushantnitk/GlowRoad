package com.example.easysoft.glowapp.view.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.easysoft.glowapp.R;
import com.example.easysoft.glowapp.model.PhotoList;
import com.example.easysoft.glowapp.model.Project;
import com.example.easysoft.glowapp.view.adapter.PhotoListAdapter;
import com.example.easysoft.glowapp.viewmodel.PhotoListViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YATRAONLINE\sushant.kumar on 24/8/18.
 */

public class PhotoListFragment extends Fragment {
    public static final String TAG = "PhotoListFragment";
    public RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout refreshLayout;
    private List<PhotoList> photoLists = new ArrayList<>();
    private PhotoListAdapter photoListAdapter;
    private PhotoListViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.layout_list,null);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initList();
        viewModel = ViewModelProviders.of(this).get(PhotoListViewModel.class);
        observeViewModel(viewModel);
    }

    private void observeViewModel(PhotoListViewModel viewModel) {
        // Update the list when the data changes
        viewModel.getProjectListObservable().observe(this, new Observer<Project>() {
            @Override
            public void onChanged(@Nullable Project projects) {
                if (projects != null) {
                    List<PhotoList> photos = projects.getPhotoList();
                    photoLists.addAll(photos);
                    photoListAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void initList() {
        refreshLayout = getActivity().findViewById(R.id.swipe_layout);
        recyclerView = getActivity().findViewById(R.id.recycler_view);
        refreshLayout.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        photoListAdapter = new PhotoListAdapter(getActivity(),photoLists);
        recyclerView.setAdapter(photoListAdapter);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                observeViewModel(viewModel);
            }
        });
    }
}
