package models;

public class QuestModel extends AbstractItemModel<QuestCategoryModel>{

    private Integer prize;
    private String description;

    public QuestModel(String name, QuestCategoryModel category, String description, Integer prize) {
        super(name, category);
        this.prize = prize;
        this.description = description;

    }

    public Integer getPrize() {
        return this.prize;
    }

    public Integer getId() {
        return this.id;
    }
}
