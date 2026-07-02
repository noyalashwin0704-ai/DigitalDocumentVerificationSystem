package com.wipro.ddvs.entity;

public class Officer {
    private String officerId;
    private String name;
    private String department;

    public Officer(String officerId, String name, String department) {
        this.officerId = officerId;
        this.name = name;
        this.department = department;
    }

    public String getOfficerId() {
        return officerId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }
}