package models.dao;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Dao<T> implements ItemsIterator {

    protected ArrayList<T> itemsList = new ArrayList<T>();

    public void add(T item) {
        this.itemsList.add(item);
    }

    public void remove(T item) {
        this.itemsList.remove(item);
    }

    public Iterator getIterator() {
        return this.itemsList.iterator();
    }

    public abstract void read();

    public abstract void save();
}
