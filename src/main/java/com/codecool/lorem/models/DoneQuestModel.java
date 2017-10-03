package com.codecool.lorem.models;

public class DoneQuestModel extends QuestModel {

    private Integer questId;
    private Integer studentId;

    public DoneQuestModel(Integer id, String name, Integer categoryId,
            String description, Integer prize, Integer questId, Integer studentId) {
        super(id, name, categoryId, description, prize);
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
