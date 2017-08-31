package models;

public class QuestCategoryModel extends CategoryModel {

    public QuestCategoryModel(String name, String id) {
        super(name, id);
    }

    public String toString() {
        return this.id + ". " + this.name;
    }
}
