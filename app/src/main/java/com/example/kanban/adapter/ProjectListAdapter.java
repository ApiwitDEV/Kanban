package com.example.kanban.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kanban.model.ProjectItem;
import com.example.kanban.R;
import com.example.kanban.databinding.ProjectItemBinding;
import com.example.kanban.viewModel.LayoutInfo;
import com.example.kanban.viewModel.ProjectItemViewModel;

public class ProjectListAdapter extends RecyclerView.Adapter<ProjectListAdapter.ProjectListViewHolder> {

    int statePosition;
    LayoutInfo layoutInfo;
    ProjectItemViewModel projectItemViewModel;

    public ProjectListAdapter(int statePosition,LayoutInfo layoutInfo, ProjectItemViewModel projectListViewHolder) {
        this.layoutInfo = layoutInfo;
        this.projectItemViewModel = projectListViewHolder;
        this.statePosition = statePosition;
    }

    @NonNull
    @Override
    public ProjectListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ProjectItemBinding binding = DataBindingUtil
                .inflate(inflater,R.layout.project_item,parent,false);
        return new ProjectListViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectListViewHolder holder, int position) {

        Animation animation = AnimationUtils.loadAnimation(holder.binding.getRoot().getContext(), android.R.anim.slide_in_left);
        ProjectItem item = projectItemViewModel.projectList.get(position);
        if (position == 0) {
            item.firstPosition = true;
        }
        holder.binding.setLayoutInfo(layoutInfo);
        holder.binding.setProjectState(projectItemViewModel);
        holder.binding.setProjectItem(item);
        holder.binding.getRoot().setAnimation(animation);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return projectItemViewModel.projectList.size();
    }

    public static class ProjectListViewHolder extends RecyclerView.ViewHolder {

        ProjectItemBinding binding;

        public ProjectListViewHolder(ProjectItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        /*
        public void bind(Object obj) {
            binding.setVariable(BR.ProjectItem, obj);
            binding.executePendingBindings();
        }
        */
    }
}
