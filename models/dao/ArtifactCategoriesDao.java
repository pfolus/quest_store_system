package models.dao;

import java.util.Iterator;

import models.ArtifactCategoryModel;

public class ArtifactCategoriesDao extends Dao<ArtifactCategoryModel> {

    public ArtifactCategoryModel get(Integer id) {
        Iterator iter = this.getIterator();

        while (iter.hasNext()) {
            ArtifactCategoryModel user = (ArtifactCategoryModel) iter.next();

            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public void read() {}

    public void save() {}
}
