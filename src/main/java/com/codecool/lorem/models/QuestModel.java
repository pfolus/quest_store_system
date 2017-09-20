package com.codecool.lorem.models;

public class QuestModel extends AbstractItemModel {

    private Integer prize;
    private String description;

    public QuestModel(Integer id, String name, Integer categoryId, String description, Integer prize) {
        super(id, name, categoryId);
        this.prize = prize;
        this.description = description;

    }

    public Integer getPrize() {
        return this.prize;
    }

    public Integer getId() {
        return this.id;
    }

    public String getDescription() {
        return description;
    }
}
