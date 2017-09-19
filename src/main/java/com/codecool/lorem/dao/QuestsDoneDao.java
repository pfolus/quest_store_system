package com.codecool.lorem.dao;

import java.util.Iterator;

import com.codecool.lorem.models.DoneQuestModel;

public class QuestsDoneDao extends Dao<DoneQuestModel> {

    public DoneQuestModel get(Integer id) {
        Iterator iter = this.getIterator();

        while (iter.hasNext()) {
            DoneQuestModel user = (DoneQuestModel) iter.next();

            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public void read() {}

    public void save() {}
}
