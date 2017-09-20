package com.codecool.lorem.dao;

import com.codecool.lorem.models.ClassModel;

public class ClassesDao extends Dao<ClassModel> {

    public ClassModel getById(Integer id) {
        for (ClassModel cl : getItems()) {
            if (cl.getId().equals(id)) {
                return cl;
            }
        }
        return null;
    }

}
