package com.mybucket.model;

import com.mybucket.enums.Priority;
import com.mybucket.enums.Project;
import com.mybucket.enums.Status;
import com.mybucket.validation.EnumNamePattern;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;



import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Table("Task")
public class Task {
    @Id
    private int tId;
    @NotBlank(message = "Description is mandatory")
    private String description;
    @EnumNamePattern(regexp = "LOW|HIGH|MEDIUM")
    private Priority priority;
    @EnumNamePattern(regexp = "TO_DO|IN_PROGRESS|DONE")
    private Status status;
    @EnumNamePattern(regexp = "PAM|TRAVEL|LMS")
    private Project project;
    private int hourSpent;
    private int estimatedHour;
  //  @MappedCollection(keyColumn = "uid",idColumn ="uid")
   private int uid;
    
    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
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

    public int getHourSpent(int i) {
        return hourSpent;
    }

    public void setHourSpent(int hourSpent) {
        this.hourSpent = hourSpent;
    }

    public int getEstimatedHour(int i) {
        return estimatedHour;
    }

    public void setEstimatedHour(int estimatedHour) {
        this.estimatedHour = estimatedHour;
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

    @Override
    public String toString() {
        return "Task{" +
                "tId=" + tId +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", status=" + status +
                ", project=" + project +
                ", hourSpent=" + hourSpent +
                ", estimatedHour=" + estimatedHour +
                ", uid=" + uid +
                '}';
    }
}
