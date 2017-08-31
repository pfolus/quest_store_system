package models.dao;

import models.QuestDoneModel;

public class QuestsDoneDao extends Dao<QuestDoneModel> {

    public QuestDoneModel get(Integer id) {
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
