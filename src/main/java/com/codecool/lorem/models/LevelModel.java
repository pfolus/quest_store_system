package com.codecool.lorem.models;

public class LevelModel {

    private Integer requiredScore;
    private String name;
    protected Integer id;

    public LevelModel(Integer id, Integer requiredScore, String name) {
        this.requiredScore = requiredScore;
        this.name = name;
        this.id = id;
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
