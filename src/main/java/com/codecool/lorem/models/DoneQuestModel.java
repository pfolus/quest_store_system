package com.codecool.lorem.models;

public class DoneQuestModel {

    private Integer questId;
    private Integer timesDone;
    private Integer id;
    private Integer studentId;

    public DoneQuestModel(Integer id, Integer timesDone, Integer questId, Integer studentId) {
        this.questId = questId;
        this.timesDone = timesDone;
        this.id = id;
        this.studentId = studentId;
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

    public Integer getStudentId() { return this.studentId; }
}
