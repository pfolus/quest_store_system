package models.dao;

import models.ArtifactModel;

public class ArtifactsDao extends Dao<ArtifactModel> {

    public ArtifactModel get(Integer id) {
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
