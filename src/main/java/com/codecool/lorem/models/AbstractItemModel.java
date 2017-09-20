package com.codecool.lorem.models;

abstract class AbstractItemModel<T> {

    protected String name;
    protected Integer id;
    protected T category;

    public AbstractItemModel(String name, Integer id, T category) {
        this.name = name;
        this.id = id;
        this.category = category;
    }

    public String getName() {
        return this.name;
    }

    public Integer getId() {
        return this.id;
    }

    public T getCategory() {
        return this.category;
    }
}
