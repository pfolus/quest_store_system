package models;

public class BoughtArtifactModel {

    private ArtifactModel artifact;
    private Integer studentId;
    private boolean isUsed;

    public BoughtArtifactModel(ArtifactModel artifact, Integer studentId) {
        this.artifact = artifact;
        this.studentId = studentId;
        this.isUsed = false;
    }

    public BoughtArtifactModel(ArtifactModel artifact, Integer studentId, boolean isUsed) {
        this.artifact = artifact;
        this.studentId = studentId;
        this.isUsed = isUsed;
    }

