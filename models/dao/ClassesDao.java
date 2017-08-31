package models.dao;

import java.util.Iterator;

import models.ClassModel;

public class ClassesDao extends Dao<ClassModel> {

    public ClassModel get(Integer id) {
        Iterator iter = this.getIterator();

        while (iter.hasNext()) {
            ClassModel user = (ClassModel) iter.next();

            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public void read() {}

    public void save() {}
}
