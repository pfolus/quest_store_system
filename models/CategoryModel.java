package models;

public abstract class CategoryModel {

    protected Integer id;
    protected String name;

    public CategoryModel(String name, String id) {
        this.name = name;
        this.id = id;
    }
}
