package com.codecool.lorem.dao;

import java.util.ArrayList;

public abstract class Dao<T> {

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
}
