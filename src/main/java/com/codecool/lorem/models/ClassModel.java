package com.codecool.lorem.models;

public class ClassModel {

    private Integer id;
    private String name;

    public ClassModel(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }
}
