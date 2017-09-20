package com.codecool.lorem.dao;

import java.util.Iterator;

import com.codecool.lorem.models.LevelModel;

public class LevelsDao extends Dao<LevelModel> {

    public LevelModel getById(Integer id) {
        for (LevelModel level : getItems()) {
            if (level.getId().equals(id)) {
                return level;
            }
        }
        return null;
    }

}
