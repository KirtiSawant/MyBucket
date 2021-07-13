package com.mybucket.enums;

public enum Direction {
    ASCENDING("ASC"),
    DESCENDING("DESC");
    private final String directionCode;
     Direction(String direction) {
        this.directionCode = direction;
    }
    public String getDirectionCode() {
        return this.directionCode;
    }
}
