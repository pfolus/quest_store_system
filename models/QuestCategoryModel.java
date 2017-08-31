package models;

public class QuestCategoryModel extends CategoryModel {

    public QuestCategoryModel(String name, String id) {
        super(name, id);
    }

    public void toString() {
        return this.id + ". " + this.name;
    }
}
