package com.example.kanban.UI.Home;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.kanban.R;
import com.example.kanban.UI.MainActivity;
import com.example.kanban.model.ProjectItem;
import com.example.kanban.adapter.ProjectListAdapter;
import com.example.kanban.databinding.FragmentProjectBinding;
import com.example.kanban.viewModel.ProjectItemViewModel;

import java.util.ArrayList;

public class Project_Fragment extends Fragment {

    private int statePosition;

    public Project_Fragment(int statePosition) {
        // Required empty public constructor
        this.statePosition = statePosition;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentProjectBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_project,container,false);
        View v = binding.getRoot();
        binding.setLifecycleOwner(this);
        ProjectItemViewModel projectItemViewModel = new ViewModelProvider(this).get(ProjectItemViewModel.class);

        ArrayList<ProjectItem> itemList = new ArrayList<>();

        for (int i = 1 ; i <= 100;i++) {
            ProjectItem item = new ProjectItem("Project "+ i,"14:25 02/06/2022");
            itemList.add(item);
        }

        projectItemViewModel.projectList = itemList;
        projectItemViewModel.statePosition = statePosition;
        projectItemViewModel.Ntab = Home_Fragment.NTab;
        ProjectListAdapter projectListAdapter = new ProjectListAdapter(statePosition,MainActivity.info,projectItemViewModel);
        binding.setMyadapter(projectListAdapter);
        if (statePosition == 1) {
            Toast.makeText(getContext(), "position one", Toast.LENGTH_SHORT).show();
        }
        return v;
    }
}