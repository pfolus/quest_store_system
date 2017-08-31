package models.dao;

import models.LevelModel;

public class LevelsDao extends Dao<LevelModel> {

    public LevelModel get(Integer id) {
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
