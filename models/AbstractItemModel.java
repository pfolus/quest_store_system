package models;

abstract class AbstractItemModel<T> {

    private String name;
    private Integer Id;
    private T category;

    private static Integer nextId;

    public AbstractItemModel(String name, T category) {
        this.name = name;
        this.Id = nextId++;
        this.category = category;
    }

    public String getName() {
        return this.name;
    }

    public Integer getId() {
        return this.ID;
    }

    public T getCategory() {
        return this.category;
    }
}
