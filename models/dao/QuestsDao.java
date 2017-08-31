package models.dao;

import java.util.Iterator;

import models.QuestModel;

public class QuestsDao extends Dao<QuestModel> {

    public QuestModel get(Integer id) {
        Iterator iter = this.getIterator();

        while (iter.hasNext()) {
            QuestModel user = (QuestModel) iter.next();

            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public void read() {}

    public void save() {}
}
