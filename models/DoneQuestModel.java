package models;

public class DoneQuestModel {

    private QuestModel quest;
    private Integer timesDone;

    public DoneQuestModel(QuestModel quest) {
        this.quest = quest;
        this.timesDone = 1;
    }

    public void increaseTimesDone() {
        this.timesDone += 1;
    }

    public QuestModel getQuest() {
        return this.quest;
    }

    public Integer getTimesDone() {
        return this.timesDone;
    }
}
