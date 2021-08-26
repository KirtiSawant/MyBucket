package com.mybucket.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class Sprint {
    @Id
    private int sid;
    @NotEmpty(message = "Name is mandatory")
    private String name;
    @NotEmpty(message = "description is required")
    private String description;
    private Date startDate;
    private Date endDate;
    @MappedCollection(keyColumn ="sid",idColumn ="sid")
    private Task tasks;

    public Sprint(int sid, String name, String description, Date startDate, Date endDate, Task tasks) {
        this.sid = sid;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        /*this.tasks = tasks;*/
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Sprint() {
    }
}
