package com.codecool.lorem.dao;

import java.util.Iterator;

import com.codecool.lorem.models.DoneQuestModel;

public class QuestsDoneDao extends Dao<DoneQuestModel> {

    public DoneQuestModel get(Integer id) {
        for (DoneQuestModel quest : getItems()) {
            if (quest.getId().equals(id)) {
                return quest;
            }
        }
        return null;
    }
}
