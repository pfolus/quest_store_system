package com.codecool.lorem.models;

public abstract class CategoryModel {

    protected Integer id;
    protected String name;

    public CategoryModel(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }
}
