package com.codecool.lorem.models;

public class ArtifactModel extends AbstractItemModel<ArtifactCategoryModel> {

    private Integer price;
    private String description;

    public ArtifactModel(String name, Integer id, ArtifactCategoryModel category, String description, Integer price) {
        super(name, id, category);
        this.price = price;
        this.description = description;
    }

    public Integer getPrice() {
        return this.price;
    }

    public String toString() {
        return  "ID: " + this.id
                + " Name: " + this.name
                + " Category: " + this.category.toString()
                + " Description: " + this.description
                + " Price: " + this.price;
    }
}
