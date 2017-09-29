package com.codecool.lorem.models;

public class ClassModel extends AbstractItemModel{

    private String name;

    public ClassModel(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() { return this.id + ". " + this.name; }
}
