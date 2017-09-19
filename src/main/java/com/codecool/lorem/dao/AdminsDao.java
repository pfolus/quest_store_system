package com.codecool.lorem.dao;

import java.util.Iterator;

import com.codecool.lorem.models.AdminModel;

public class AdminsDao extends Dao<AdminModel> {

    public AdminModel get(Integer id) {
        Iterator iter = this.getIterator();

        while (iter.hasNext()) {
            AdminModel user = (AdminModel) iter.next();

            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public void read() {}

    public void save() {}
}
