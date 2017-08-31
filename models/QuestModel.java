public class QuestModel extends AbstractItemModel<QuestCategory>{

    private Integer prize;

    public Artifact(String name, QuestCategory category, Integer prize) {
        super(name, category);
        this.prize = prize;

    }

    public Integer getPrize() {
        return this.prize;
    }
}
