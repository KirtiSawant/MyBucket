package com.mybucket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatisticsSprintUser {

    private String name;
    private String userName;
    private int statusdone;
    private int statustodo;
    private int statusinprogress;
}
