abstract class AbstractItem<T>{

    private String name;
    private Integer ID;
    private <T> category;

    private static Integer nextID;

    public AbstractItem(String name, T category) {
        this.name = name;
        this.ID = nextID++;
        this.category = category;
    }
