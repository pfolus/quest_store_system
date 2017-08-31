package models;

public abstract class CategoryModel {

    protected Integer id;
    protected String name;

    Category(String name, String id) {
        this.name = name;
        this.id = id;
    }
}
