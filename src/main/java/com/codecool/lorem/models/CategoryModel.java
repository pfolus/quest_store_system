package com.codecool.lorem.models;

public abstract class CategoryModel {

    protected Integer id;
    protected String name;

    public CategoryModel(Integer id, String name) {
        this.name = name;
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }
}
