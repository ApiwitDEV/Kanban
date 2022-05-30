package com.example.kanban.model;

public class ProjectItem {
    public String projectTitle;
    public String deadLine;
    public ProjectItem(String projectTitle,String deadLine) {
        this.projectTitle = projectTitle;
        this.deadLine = deadLine;
    }
}
