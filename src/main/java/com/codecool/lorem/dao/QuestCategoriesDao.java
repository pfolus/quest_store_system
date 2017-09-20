package com.codecool.lorem.dao;

import java.util.Iterator;

import com.codecool.lorem.models.QuestCategoryModel;

public class QuestCategoriesDao extends Dao<QuestCategoryModel> {

    public QuestCategoryModel get(Integer id) {
        for (QuestCategoryModel questCategory : getItems()) {
            if (questCategory.getId().equals(id)) {
                return questCategory;
            }
        }
        return null;
    }
}
