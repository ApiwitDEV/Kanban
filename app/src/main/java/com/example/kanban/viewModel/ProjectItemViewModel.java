package com.example.kanban.viewModel;

import android.view.View;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.kanban.UI.Home.Home_Fragment;
import com.example.kanban.model.ProjectItem;

import java.util.ArrayList;

public class ProjectItemViewModel extends ViewModel {

    public ArrayList<ProjectItem> projectList;
    public int statePosition;
    public static int Ntab;

    @BindingAdapter("setState")
    public static void setState(View view,int statePosition) {
        if (statePosition == 0) {
            view.setVisibility(View.GONE);
        }
        else if (statePosition == Home_Fragment.NTab - 1) {
            view.setVisibility(View.GONE);
        }
        else {
            view.setVisibility(View.VISIBLE);
        }
    }
}
