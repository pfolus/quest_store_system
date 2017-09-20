package com.codecool.lorem.models;

public class BoughtArtifactModel {

    private Integer artifactId;
    private Integer studentId;
    private boolean isUsed;
    private Integer id;

    public BoughtArtifactModel(Integer id, Integer artifactId, Integer studentId, Boolean isUsed) {
        this.artifactId = artifactId;
        this.studentId = studentId;
        this.isUsed = isUsed;
        this.id = id;
    }

    public void markAsUsed() {
        this.isUsed = true;
    }

    public Integer getId() {
        return this.id;
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
}
