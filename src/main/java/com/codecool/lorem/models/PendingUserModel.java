package com.codecool.lorem.models;

public class PendingUserModel {

    private String id;
    private String type;

    public PendingUserModel(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
