package com.codecool.lorem.dao;

import com.codecool.lorem.views.MainView;

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

    public void showItems() {
        if (this.getItems().size() > 0) {
            for (T object : this.getItems()) {
                MainView.showString(object.toString());
            }
            MainView.newLine();
        } else {
            MainView.showString("List is empty!\n ");
        }
    }
}
