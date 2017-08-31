package models.dao;

import java.util.Iterator;

import models.LevelModel;

public class LevelsDao extends Dao<LevelModel> {

    public LevelModel get(Integer id) {
        Iterator iter = this.getIterator();

        while (iter.hasNext()) {
            LevelModel user = (LevelModel) iter.next();

            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public void read() {}

    public void save() {}
}
