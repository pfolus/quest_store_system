package com.codecool.lorem.models;

abstract class AbstractQuestArtifactModel extends AbstractItemModel {

    protected String name;
    protected Integer categoryId;
    protected String description;


    public AbstractQuestArtifactModel(Integer id, String name, Integer categoryId, String description) {
        super(id);
        this.name = name;
        this.categoryId = categoryId;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public Integer getCategoryId() {
        return this.categoryId;
    }
}
