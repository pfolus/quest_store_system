package com.codecool.lorem.models;

public class DoneQuestModel extends AbstractItemModel {

    private Integer questId;
    private Integer studentId;

    public DoneQuestModel(Integer id, Integer questId, Integer studentId) {
        super(id);
        this.questId = questId;
        this.studentId = studentId;
    }

    public Integer getQuestId() {
        return this.questId;
    }

    public Integer getId() {
        return this.id;
    }

    public Integer getStudentId() { return this.studentId; }
}
