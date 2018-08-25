package com.example.easysoft.glowapp.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.example.easysoft.glowapp.model.Project;
import com.example.easysoft.glowapp.util.ProjectRepository;

public class PhotoListViewModel extends ViewModel {
   private ProjectRepository projectRepository;
    private final LiveData<Project> projectListObservable;
    public PhotoListViewModel() {
        super();
        projectRepository = new ProjectRepository();
        projectListObservable = projectRepository.getProjectList();
    }

    /**
     * Expose the LiveData Projects query so the UI can observe it.
     */
    public LiveData<Project> getProjectListObservable() {
        return projectListObservable;
    }
}