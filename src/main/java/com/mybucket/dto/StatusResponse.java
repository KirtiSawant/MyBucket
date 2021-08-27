package com.mybucket.dto;

import com.mybucket.enums.Priority;
import com.mybucket.enums.Project;
import com.mybucket.enums.Status;
import com.mybucket.model.Sprint;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class StatusResponse {
    private int tId;
    private String description;
    private Priority priority;
    private Status status;
    private Project project;
    private int hourSpent;
    private int estimatedHour;
    private int sid;
    private String name;
    private Date startDate;
    private Date endDate;

    public StatusResponse(int tId, String description, Priority priority, Status status, Project project, int hourSpent, int estimatedHour, int sid, String name, Date startDate, Date endDate) {
        this.tId = tId;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.project = project;
        this.hourSpent = hourSpent;
        this.estimatedHour = estimatedHour;
        this.sid = sid;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
