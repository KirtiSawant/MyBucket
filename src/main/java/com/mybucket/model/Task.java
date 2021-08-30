package com.mybucket.model;

import com.mybucket.enums.Priority;
import com.mybucket.enums.Project;
import com.mybucket.enums.Status;
import com.mybucket.validation.EnumNamePattern;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Data
@Table("Task")
public class Task {
    @Id
    private int tId;
    @NotBlank(message = "Description is mandatory")
    private String description;


    @EnumNamePattern(message = "Must be any of Enum LOW/HIGH/MEDIUM",enumClass =Priority.class)
    private String priority;

    @EnumNamePattern(message = "Must be any of Enum DONE/IN_PROGRESS/TO_DO",enumClass = Status.class)
    private String status;

    @EnumNamePattern(message = "Must be any of Enum PAM/TRAVEL/LMS",enumClass = Project.class)
    private String project;

    @NotNull
    @Min(value=1, message="required")
    private int hourSpent;

    @Min(value=1, message="required")
    private int estimatedHour;
   /* @MappedCollection(keyColumn ="sid",idColumn ="sid")
    private Sprint sprint;
    @MappedCollection(keyColumn = "uid",idColumn ="uid")
    private User users;*/
   // @MappedCollection(keyColumn ="sid",idColumn ="sid")
   private int sid;
  //  @MappedCollection(keyColumn = "uid",idColumn ="uid")
    private int uid;


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

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String  getStatus() {
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

    /*public Sprint getSprint() {
        return sprint;
    }

    public void setSprint(Sprint sprint) {
        this.sprint = sprint;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }*/
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "Task{" +
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
