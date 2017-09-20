package com.codecool.lorem.dao;

import com.codecool.lorem.models.AdminModel;

public class AdminsDao extends Dao<AdminModel> {

    public AdminModel get(Integer id) {
        for (AdminModel admin : getItems()) {
            if (admin.getId().equals(id)) {
                return admin;
            }
        }
        return null;
    }

    public void read() {}

    public void save() {}
}
