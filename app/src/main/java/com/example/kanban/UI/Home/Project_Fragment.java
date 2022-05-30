package com.example.kanban.UI.Home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.kanban.model.ProjectItem;
import com.example.kanban.adapter.ProjectListAdapter;
import com.example.kanban.databinding.FragmentProjectBinding;

import java.util.ArrayList;

public class Project_Fragment extends Fragment {

    private int position;

    public Project_Fragment(int position) {
        // Required empty public constructor
        this.position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentProjectBinding binding = FragmentProjectBinding.inflate(inflater,container,false);
        View v = binding.getRoot();
        ProjectItem item1 = new ProjectItem("KanBan Project","14:25 02/06/2022");
        ProjectItem item2 = new ProjectItem("XXX Project","14:25 02/06/2022");
        ArrayList<ProjectItem> itemList = new ArrayList<>();
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item1);
        itemList.add(item2);
        ProjectListAdapter projectListAdapter = new ProjectListAdapter(itemList);
        binding.project.setAdapter(projectListAdapter);
        binding.project.setLayoutManager(new LinearLayoutManager(getContext()));
        if (position == 1) {
            Toast.makeText(getContext(), "position one", Toast.LENGTH_SHORT).show();
        }
        return v;
    }
}