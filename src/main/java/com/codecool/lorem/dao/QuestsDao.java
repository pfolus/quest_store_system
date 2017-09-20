package com.codecool.lorem.dao;

import java.util.Iterator;

import com.codecool.lorem.models.QuestModel;

public class QuestsDao extends Dao<QuestModel> {

    public QuestModel get(Integer id) {
        for (QuestModel quest : getItems()) {
            if (quest.getId().equals(id)) {
                return quest;
            }
        }
        return null;
    }
}
