package com.mybucket.dto;

import com.mybucket.model.Task;
import lombok.Data;

import java.util.Date;
@Data
public class SprintDto {
    private int sid;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;

}
