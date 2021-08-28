package com.mybucket.dto;

import com.mybucket.enums.Priority;
import com.mybucket.enums.Project;
import com.mybucket.enums.Status;
import lombok.Data;

import java.util.Date;

@Data
public class StatusResponse {

    private String name;
    private Date startDate;
    private Date endDate;
    private String description;
    private Priority priority;
    private Status status;
    private Project project;
    private int hourSpent;
    private int estimatedHour;


}
