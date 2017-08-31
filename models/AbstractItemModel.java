package models;

abstract class AbstractItemModel<T> {

    private String name;
    private Integer id;
    private T category;

    private static Integer nextId;

    public AbstractItem(String name, T category) {
        this.name = name;
        this.id = nextId++;
        this.category = category;
    }

    public String getName() {
        return this.name;
    }

    public Integer getID() {
        return this.id;
    }

    public T getCategory() {
        return this.category;
    }
}
