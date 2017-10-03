package com.codecool.lorem.models;

public class PendingUser {

    private Integer id;
    private String type;

    public PendingUser(Integer id, String type) {
        this.id = id;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
