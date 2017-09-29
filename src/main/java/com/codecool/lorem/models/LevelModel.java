package com.codecool.lorem.models;

public class LevelModel extends AbstractItemModel {

    private Integer requiredScore;
    private String name;

    public LevelModel(Integer id, Integer requiredScore, String name) {
        super(id);
        this.requiredScore = requiredScore;
        this.name = name;
    }

    public Integer getRequiredScore() {
        return this.requiredScore;
    }

    public String getName() {
        return this.name;
    }
}
