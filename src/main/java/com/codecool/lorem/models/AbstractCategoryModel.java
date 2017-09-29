package com.codecool.lorem.models;

public abstract class AbstractCategoryModel extends AbstractItemModel {

    protected String name;

    public AbstractCategoryModel(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return this.id + ". " + this.name;
    }
}
