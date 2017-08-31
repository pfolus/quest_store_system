package models.dao;

import models.MentorModel;

public class MentorsDao extends Dao<MentorModel> {

    public MentorModel get(Integer id) {
        Iterator iter = this.getIterator();

        while (iter.hasNext()) {
            if (iter.next().getId().equals(id)) {
                return iter.next();
            }
        }
        return null;
    }

    public void read() {}

    public void save() {}
}
