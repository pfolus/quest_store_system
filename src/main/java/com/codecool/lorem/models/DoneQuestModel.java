package com.codecool.lorem.models;

public class DoneQuestModel {

    private Integer questId;
    private Integer timesDone;
    private Integer id;

    public DoneQuestModel(Integer id, Integer questId) {
        this.questId = questId;
        this.timesDone = 1;
        this.id = id;
    }

    public void increaseTimesDone() {
        this.timesDone += 1;
    }

    public Integer getQuestId() {
        return this.questId;
    }

    public Integer getTimesDone() {
        return this.timesDone;
    }

    public Integer getId() {
        return this.id;
    }
}
