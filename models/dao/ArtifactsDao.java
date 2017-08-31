package models.dao;

import java.util.Iterator;

import models.ArtifactModel;

public class ArtifactsDao extends Dao<ArtifactModel> {

    public ArtifactModel get(Integer id) {
        Iterator iter = this.getIterator();

        while (iter.hasNext()) {
            ArtifactModel user = (ArtifactModel) iter.next();

            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public void read() {}

    public void save() {}

}
