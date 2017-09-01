package models;

abstract class AbstractItemModel<T> {

    protected String name;
    protected Integer id;
    protected T category;

    private static Integer nextId = 1;

    public AbstractItemModel(String name, T category) {
        this.name = name;
        this.id = nextId++;
        this.category = category;
    }

    public String getName() {
        return this.name;
    }

    public Integer getId() {
        return this.id;
    }

    public T getCategory() {
        return this.category;
    }
}
