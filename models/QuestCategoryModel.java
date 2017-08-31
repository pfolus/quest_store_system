package models;

public class QuestCategoryModel extends CategoryModel {

    public QuestCategoryModel(String name) {
        super(name);
    }

    public String toString() {
        return this.id + ". " + this.name;
    }
}
