package com.codecool.lorem.models;

public class GroupTransactionModel extends AbstractItemModel {

    private Integer artifactId;
    private Integer studentId;
    private Integer price;
    private String status;

    public GroupTransactionModel(Integer id, Integer artifactId, Integer studentId, Integer price, String status) {
        super(id);
        this.artifactId = artifactId;
        this.studentId = studentId;
        this.price = price;
        this.status = status;
    }

    public Integer getArtifactId() {
        return this.artifactId;
    }

    public Integer getStudentId() {
        return this.studentId;
    }

    public Integer getPrice() {
        return this.price;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus() {
        this.status = "Marked";
    }


    public String toString() {
        return  "ID: " + this.id +
                " Artifact ID: " + artifactId +
                " Price: " + price;
    }

}
