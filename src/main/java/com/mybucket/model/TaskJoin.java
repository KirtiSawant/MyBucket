package com.mybucket.model;

import lombok.Data;

@Data
public class TaskJoin {

    private int tId;
    private String description;
    private Priority priority;
    private Status status;
    private Project project;
    private int hourSpent;
    private int estimatedHour;
    private int uid;
    private String userName;
    public TaskJoin(int tId, String description, Priority priority, Status status, Project project, int hourSpent, int estimatedHour, int uid, String userName) {
        this.tId = tId;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.project = project;
        this.hourSpent = hourSpent;
        this.estimatedHour = estimatedHour;
        this.uid = uid;
        this.userName = userName;
    }

    public int gettId() {
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

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
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

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
