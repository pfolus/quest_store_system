package models.dao;

import models.QuestModel;

public class QuestsDao extends Dao<QuestModel> {

    public QuestModel get(Integer id) {
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
