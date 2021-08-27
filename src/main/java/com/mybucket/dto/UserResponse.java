package com.mybucket.dto;

import com.mybucket.enums.Priority;
import com.mybucket.enums.Project;
import com.mybucket.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private int uid;
    private String userName;
    private int tId;
    private String description;
    private Priority priority;
    private Status status;
    private Project project;
    private int hourSpent;
    private int estimatedHour;
}
