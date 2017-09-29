package com.codecool.lorem.models;

public class ArtifactModel extends AbstractQuestArtifactModel {

    private Integer price;

    public ArtifactModel(Integer id, String name, Integer categoryId, String description, Integer price) {
        super(id, name, categoryId, description);
        this.price = price;
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
}