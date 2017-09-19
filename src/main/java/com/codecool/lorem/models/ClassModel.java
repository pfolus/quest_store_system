package com.codecool.lorem.models;

public class ClassModel {

    private Integer id;
    private String name;

    private static Integer nextId = 1;

    public ClassModel(String name) {
        this.id = nextId++;
        this.name = name;
    }

    public Integer getId() {
        return this.id;
    }
}
