package com.mybucket.controller;

import java.io.Serializable;

public class TaskDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    private int tId;
    private String description;
    private String priority;
    private String status;
    private String project;
    private int hourSpent;
    private int estimatedHour;

    public int getId() {
        return tId;
    }
    public void settId(int tId) {
        this.tId = tId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public int getHourSpent() {
        return hourSpent;
    }

    public void setHourSpent(int hourSpent) {
        this.hourSpent = hourSpent;
    }

    public int getEstimatedHour() {
        return estimatedHour;
    }

    public void setEstimatedHour(int estimatedHour) {
        this.estimatedHour = estimatedHour;
    }


    @Override
    public String toString() {
        return "TaskDetails{" +
                "tId=" + tId +
                ", description='" + description + '\'' +
                ", priority='" + priority + '\'' +
                ", status='" + status + '\'' +
                ", project='" + project + '\'' +
                ", hourSpent=" + hourSpent +
                ", estimatedHour=" + estimatedHour +
                '}';
    }
}
