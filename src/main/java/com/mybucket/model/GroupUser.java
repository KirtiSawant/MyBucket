package com.mybucket.model;

import com.mybucket.enums.Status;
import lombok.Data;

@Data
public class GroupUser {
    private int uid;
    private int tId;
    private String userName;
    private int estimatedHour;
    private Status status;

    public GroupUser(int uid, int tId, String userName, int estimatedHour, Status status) {
        this.uid = uid;
        this.tId = tId;
        this.userName = userName;
        this.estimatedHour = estimatedHour;
        this.status = status;
    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
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

    public int getEstimatedHour() {
        return estimatedHour;
    }

    public void setEstimatedHour(int estimatedHour) {
        this.estimatedHour = estimatedHour;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}