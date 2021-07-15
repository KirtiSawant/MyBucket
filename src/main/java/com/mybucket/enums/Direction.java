package com.mybucket.enums;

import org.springframework.data.domain.Sort;

public enum Direction {
    ASCENDING("ASC"),
    DESCENDING("DESC");
    public static  Sort.Direction DESC ;
    public static Sort.Direction ASC ;
    private final String directionCode;
     Direction(String direction) {
        this.directionCode = direction;
    }
    public String getDirectionCode() {
        return this.directionCode;
    }
}
