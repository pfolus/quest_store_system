package com.codecool.lorem.models;

public class ArtifactCategoryModel extends CategoryModel {

    public ArtifactCategoryModel(Integer id, String name) {
        super(id, name);
    }

    public String toString() {
        return this.id + ". " + this.name;
    }
}
