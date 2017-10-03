package com.codecool.lorem.dao;

import java.util.ArrayList;

import com.codecool.lorem.models.AbstractItemModel;

public abstract class Dao<T extends AbstractItemModel> {

    protected ArrayList<T> itemsList = new ArrayList<>();

    public void addToList(T item) {
        this.itemsList.add(item);
    }

    public void removeFromList(T item) {
        this.itemsList.remove(item);
    }

    public ArrayList<T> getItems() {
        return this.itemsList;
    }

    public T getById(Integer id) {
        return getItems().stream()
                         .filter(item -> item.getId().equals(id))
                         .findFirst()
                         .orElse(null);
    }

    public Integer getNextId() {
        return getItems().stream()
                         .mapToInt(AbstractItemModel::getId)
                         .max()
                         .orElse(0) + 1;
    }

}
