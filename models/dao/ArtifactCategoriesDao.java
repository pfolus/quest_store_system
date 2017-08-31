package models.dao;

import models.ArtifactCategoryModel;

public class ArtifactCategoriesDao extends Dao<ArtifactCategoryModel> {

    public ArtifactCategoryModel get(Integer id) {
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
