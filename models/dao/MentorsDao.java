package models.dao;

import java.util.Iterator;

import models.MentorModel;

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
