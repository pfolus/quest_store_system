package models.dao;

import java.util.Iterator;

import models.QuestDoneModel;

public class QuestsDoneDao extends Dao<QuestDoneModel> {

    public QuestDoneModel get(Integer id) {
        Iterator iter = this.getIterator();

        while (iter.hasNext()) {
            QuestDoneModel user = (QuestDoneModel) iter.next();

            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public void read() {}

    public void save() {}
}
