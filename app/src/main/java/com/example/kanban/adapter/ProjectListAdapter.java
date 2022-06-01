package com.example.kanban.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kanban.model.ProjectItem;
import com.example.kanban.R;
import com.example.kanban.databinding.ProjectItemBinding;
import com.example.kanban.viewModel.LayoutInfo;

import java.util.ArrayList;

public class ProjectListAdapter extends RecyclerView.Adapter<ProjectListAdapter.ProjectListViewHolder> {

    ArrayList<ProjectItem> itemList;
    LayoutInfo layoutInfo;

    public ProjectListAdapter(ArrayList<ProjectItem> item,LayoutInfo layoutInfo) {
        this.itemList = item;
        this.layoutInfo = layoutInfo;
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
        //holder.cardView.getLayoutParams().height =;
        //holder.cardView.getLayoutParams().width =;
        ProjectItem item = itemList.get(position);
        if (position == 0) {
            item.firstPosition = true;
        }
        //holder.projectTitle.setText(itemList.get(position).projectTitle);
        //holder.deadLine.setText(itemList.get(position).deadLine);
        //holder.bind(item);
        holder.binding.setLayoutInfo(layoutInfo);
        holder.binding.setProjectItem(item);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return itemList.size();
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
