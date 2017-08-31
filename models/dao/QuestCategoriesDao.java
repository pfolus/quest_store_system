package models.dao;

import models.QuestCategoryModel;

public class QuestCategoriesDao extends Dao<QuestCategoryModel> {

    public QuestCategoryModel get(Integer id) {
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
