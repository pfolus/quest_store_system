package com.codecool.lorem.models;

public class QuestCategoryModel extends CategoryModel {

    public QuestCategoryModel(Integer id, String name) {
        super(id, name);
    }

    public String toString() {
        return this.id + ". " + this.name;
    }
}
