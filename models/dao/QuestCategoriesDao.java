package models.dao;

import java.util.Iterator;

import models.QuestCategoryModel;

public class QuestCategoriesDao extends Dao<QuestCategoryModel> {

    public QuestCategoryModel get(Integer id) {
        Iterator iter = this.getIterator();

        while (iter.hasNext()) {
            QuestCategoryModel user = (QuestCategoryModel) iter.next();

            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public void read() {}

    public void save() {}
}
