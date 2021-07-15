package com.mybucket.enums;

public enum OrderBy {
    ID("t_id"), Project("project");
    private String OrderByCode;
    private OrderBy(String orderBy) {
        this.OrderByCode = orderBy;
    }
    public String getOrderByCode() {
        return this.OrderByCode;
    }
}
