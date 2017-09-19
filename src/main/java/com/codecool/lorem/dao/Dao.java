package com.codecool.lorem.dao;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Dao<T> implements ItemsIterator<T> {

    protected ArrayList<T> itemsList = new ArrayList<T>();

    public void add(T item) {
        this.itemsList.add(item);
    }

    public void remove(T item) {
        this.itemsList.remove(item);
    }

    public Iterator<T> getIterator() {
        return this.itemsList.iterator();
    }

    public abstract void read();

    public abstract void save();
}
