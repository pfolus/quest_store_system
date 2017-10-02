package com.codecool.lorem.models;

public class QuestModel extends AbstractQuestArtifactModel {

    private Integer prize;

    public QuestModel(Integer id, String name, Integer categoryId, String description, Integer prize) {
        super(id, name, categoryId, description);
        this.prize = prize;
    }

    public Integer getPrize() {
        return this.prize;
    }

    public String toString() {
        return this.getId() + ". " + this.getName();
    }
}
