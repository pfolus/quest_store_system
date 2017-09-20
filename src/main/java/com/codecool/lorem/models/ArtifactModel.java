package com.codecool.lorem.models;

public class ArtifactModel extends AbstractItemModel {

    private Integer price;
    private String description;

    public ArtifactModel(Integer id, String name, Integer categoryId, String description, Integer price) {
        super(id, name, categoryId);
        this.price = price;
        this.description = description;
    }

    public Integer getPrice() {
        return this.price;
    }

    public String toString() {
        return  "ID: " + this.id
                + " Name: " + this.name
                + " CategoryId: " + this.categoryId
                + " Description: " + this.description
                + " Price: " + this.price;
    }

    public String getDescription() {
        return description;
    }
}
