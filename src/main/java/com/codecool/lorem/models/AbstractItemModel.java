package com.codecool.lorem.models;

abstract class AbstractItemModel {

    protected String name;
    protected Integer id;
    protected Integer categoryId;

    public AbstractItemModel(Integer id, String name, Integer categoryId) {
        this.name = name;
        this.id = id;
        this.categoryId = categoryId;
    }

    public String getName() {
        return this.name;
    }

    public Integer getId() {
        return this.id;
    }

    public Integer getCategoryId() {
        return this.categoryId;
    }
}
