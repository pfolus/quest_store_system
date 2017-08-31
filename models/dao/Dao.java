package models.dao;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Dao<T> implements ItemsIterator {

    protected ArrayList<T> itemsList = new ArrayList<T>();

    public void add(T item) {
        this.itemsList.add(item);
    }

    public void remove(Integer ID) {
        Iterator iter = this.getIterator();

        while (iter.hasNext()) {
            if (iter.next().getID().equals(ID)) {
                iter.remove();
            }
        }
    }

    public Iterator getIterator() {
        return this.itemsList.iterator();
    }

    public abstract void read();

    public abstract void save();
}
