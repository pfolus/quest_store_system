package com.codecool.lorem.dao;

import java.util.Iterator;

import com.codecool.lorem.models.MentorModel;

public class MentorsDao extends Dao<MentorModel> {

    public MentorModel get(Integer id) {
        Iterator iter = this.getIterator();

        while (iter.hasNext()) {
            MentorModel user = (MentorModel) iter.next();

            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public void read() {}

    public void save() {}
}
