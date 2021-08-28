package com.mybucket.dto;

import com.mybucket.enums.Priority;
import com.mybucket.enums.Project;
import com.mybucket.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private String name;
    private String userName;
    private String description;
    private Priority priority;
    private Status status;
    private Project project;
    private int hourSpent;
    private int estimatedHour;
}
