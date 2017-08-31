package models;

public abstract class CategoryModel {

    protected Integer id;
    protected String name;
    private static Integer nextId = 1;

    public CategoryModel(String name) {
        this.name = name;
        this.id = nextId++;
    }
}
