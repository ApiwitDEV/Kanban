package com.example.kanban.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kanban.Model.ProjectItem;
import com.example.kanban.R;

import java.util.ArrayList;

public class ProjectListAdapter extends RecyclerView.Adapter<ProjectListAdapter.ProjectListViewHolder> {

    ArrayList<ProjectItem> itemList;

    public ProjectListAdapter(ArrayList<ProjectItem> item) {
        this.itemList = item;
    }

    @NonNull
    @Override
    public ProjectListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.project_item,parent,false);
        return new ProjectListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectListViewHolder holder, int position) {
        holder.projectTitle.setText(itemList.get(position).projectTitle);
        holder.deadLine.setText(itemList.get(position).deadLine);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ProjectListViewHolder extends RecyclerView.ViewHolder {
        TextView projectTitle;
        TextView deadLine;
        public ProjectListViewHolder(@NonNull View itemView) {
            super(itemView);
            projectTitle = itemView.findViewById(R.id.ProjectTitle);
            deadLine = itemView.findViewById(R.id.deadline);

        }
    }
}
