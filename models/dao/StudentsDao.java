package models.dao;

import java.util.Iterator;

import models.StudentModel;

public class StudentsDao extends Dao<StudentModel> {

    public StudentModel get(Integer id) {
        Iterator iter = this.getIterator();

        while (iter.hasNext()) {
            StudentModel user = (StudentModel) iter.next();

            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public void read() {}

    public void save() {}
}
