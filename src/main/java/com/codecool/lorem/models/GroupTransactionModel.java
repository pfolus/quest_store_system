package com.codecool.lorem.models;

public class GroupTransactionModel extends AbstractItemModel {

    private Integer artifactId;
    private Integer studentsAccepted;
    private Integer requiredAcceptances;
    private Integer studentId;
    private Integer price;
    private String status;

    public GroupTransactionModel(Integer id, Integer artifactId, Integer studentsAccepted, Integer requiredAcceptances, Integer studentId, Integer price, String status) {
        super(id);
        this.artifactId = artifactId;
        this.studentsAccepted = studentsAccepted;
        this.requiredAcceptances = requiredAcceptances;
        this.studentId = studentId;
        this.price = price;
        this.status = status;
    }

    public Integer getArtifactId() {
        return this.artifactId;
    }

    public Integer getStudentsAccepted() {
        return this.studentsAccepted;
    }

    public Integer getRequiredAcceptances() {
        return this.requiredAcceptances;
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

    public void raiseStudentsAccepted() {
        this.studentsAccepted += 1;
    }

    public String toString() {
        return  "ID: " + this.id +
                " Artifact ID: " + artifactId +
                " Accepted: " + studentsAccepted +
                " Required: " + requiredAcceptances +
                " Price: " + price;
    }

}
