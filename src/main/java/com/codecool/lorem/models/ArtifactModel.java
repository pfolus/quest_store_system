package com.codecool.lorem.models;

public class ArtifactModel extends AbstractItemModel<ArtifactCategoryModel> {

    private Integer price;
    private String description;

    public ArtifactModel(String name, ArtifactCategoryModel category, String description, Integer price) {
        super(name, category);
        this.price = price;
        this.description = description;
    }

    public Integer getPrice() {
        return this.price;
    }

    public String toString() {
        return "Name: " + this.name
               + " Category: " + this.category.toString()
               + " Price: " + this.price;
    }
}
