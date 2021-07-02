package com.mybucket.task.model;

import com.mybucket.user.model.User;
import org.springframework.data.relational.core.mapping.Column;

import javax.persistence.*;

@Entity

public class Task {
    @Id
    @GeneratedValue
    private int tid;
    @OneToOne
    @JoinColumn(name="id")
    private User user;

    private String description;

    @Enumerated(EnumType.STRING)
    private Priority priority;
    private Status status;
    private Project project;

    private int hour_spent;

    private int estimated_hour;

    public Task(int tid, String description, int hour_spent, int estimated_hour) {
        this.tid=tid;
        this.description=description;
        this.hour_spent=hour_spent;
        this.estimated_hour=estimated_hour;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
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

    public int getHour_spent() {
        return hour_spent;
    }

    public void setHour_spent(int hour_spent) {
        this.hour_spent = hour_spent;
    }

    public int getEstimated_hour() {
        return estimated_hour;
    }

    public void setEstimated_hour(int estimated_hour) {
        this.estimated_hour = estimated_hour;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
}
