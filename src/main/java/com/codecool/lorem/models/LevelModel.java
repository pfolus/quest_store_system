package com.codecool.lorem.models;

public class LevelModel {

    private Integer requiredScore;
    private String name;
    protected Integer id;

    private static Integer nextId = 1;

    public LevelModel(Integer requiredScore, String name) {
        this.requiredScore = requiredScore;
        this.name = name;
        this.id = nextId++;
    }

    public Integer getRequiredScore() {
        return this.requiredScore;
    }

    public String getName() {
        return this.name;
    }

    public Integer getId() {
        return this.id;
    }
}
