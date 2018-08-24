package com.example.easysoft.glowapp.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.easysoft.glowapp.model.Project;
import com.example.easysoft.glowapp.util.ProjectRepository;

public class PhotoListViewModel extends AndroidViewModel {
    private final LiveData<Project> projectListObservable;
    public PhotoListViewModel(@NonNull ProjectRepository projectRepository, @NonNull Application application) {
        super(application);

        // If any transformation is needed, this can be simply done by Transformations class ...
        projectListObservable = projectRepository.getProjectList();
    }

    /**
     * Expose the LiveData Projects query so the UI can observe it.
     */
    public LiveData<Project> getProjectListObservable() {
        return projectListObservable;
    }
}