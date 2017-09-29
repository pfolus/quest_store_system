package com.codecool.lorem.models;

public class DoneQuestModel extends AbstractItemModel {

    private Integer questId;
    private Integer timesDone;
    private Integer studentId;

    public DoneQuestModel(Integer id, Integer timesDone, Integer questId, Integer studentId) {
        super(id);
        this.questId = questId;
        this.timesDone = timesDone;
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
