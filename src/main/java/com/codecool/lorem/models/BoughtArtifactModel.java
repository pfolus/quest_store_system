package com.codecool.lorem.models;


public class BoughtArtifactModel extends ArtifactModel{

    private Integer artifactId;
    private Integer studentId;
    private boolean isUsed;

    public BoughtArtifactModel(Integer id, Integer artifactId, Integer studentId, Boolean isUsed,
                               String name, Integer categoryId, String description, Integer price) {

        super(id, name, categoryId, description, price);

        this.artifactId = artifactId;
        this.studentId = studentId;
        this.isUsed = isUsed;
    }

    public void markAsUsed() {
        this.isUsed = true;
    }

    public Integer getStudentId() {
        return this.studentId;
    }

    public Integer getArtifactId() {
        return artifactId;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public String toString() {
        String isUsed = "";

        if (this.isUsed) {
            isUsed = "Used";
        } else {
            isUsed = "Unused";
        }
        return  "| Name: " + this.name
                + "| Description: " + this.getDescription()
                + "| Condition:  " + isUsed
                + "| Price: " + this.getPrice();
    }
}
