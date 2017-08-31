package models;

public class LevelModel {

    private Integer requiredScore;
    private String name;

    public LevelModel(Integer requiredScore, String name) {
        this.requiredScore = requiredScore;
        this.name = name;
    }

    public Integer getRequiredScore() {
        return this.requiredScore;
    }

    public String getName() {
        return this.name;
    }
}
