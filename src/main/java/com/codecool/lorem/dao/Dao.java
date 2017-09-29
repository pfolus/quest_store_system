package com.codecool.lorem.dao;

import java.util.ArrayList;

import com.codecool.lorem.models.AbstractItemModel;

public abstract class Dao<T extends AbstractItemModel> {

    protected ArrayList<T> itemsList = new ArrayList<>();

    public void add(T item) {
        this.itemsList.add(item);
    }

    public void remove(T item) {
        this.itemsList.remove(item);
    }

    public ArrayList<T> getItems() {
        return this.itemsList;
    }

    public T getById(Integer id) {
        return getItems().stream()
                         .filter(item -> item.getId().equals(id))
                         .findFirst()
                         .get();
    }

    public Integer getNextId() {
        return getItems().stream()
                         .mapToInt(AbstractItemModel::getId)
                         .max()
                         .getAsInt() + 1;
    }

}
