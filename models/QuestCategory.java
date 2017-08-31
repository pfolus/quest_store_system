package models;

public class QuestCategory extends Category {

    public QuestCategory(String name, String id) {
        super(name, id);
    }

    public void toString() {
        return this.id + ". " + this.name;
    }
}
