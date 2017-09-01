package models;

public class BoughtArtifactModel {

    private ArtifactModel artifact;
    private Integer studentId;
    private boolean isUsed;
    private Integer id;

    private static Integer nextId = 1;

    public BoughtArtifactModel(ArtifactModel artifact, Integer studentId) {
        this.artifact = artifact;
        this.studentId = studentId;
        this.isUsed = false;
        this.id = nextId++;
    }

    public BoughtArtifactModel(ArtifactModel artifact, Integer studentId, boolean isUsed) {
        this.artifact = artifact;
        this.studentId = studentId;
        this.isUsed = isUsed;
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
}
