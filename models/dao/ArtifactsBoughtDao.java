package models.dao;

import java.util.Iterator;

import models.BoughtArtifactModel;

public class ArtifactsBoughtDao extends Dao<BoughtArtifactModel> {

    public BoughtArtifactModel get(Integer id) {
        Iterator iter = this.getIterator();

        while (iter.hasNext()) {
            BoughtArtifactModel user = (BoughtArtifactModel) iter.next();

            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public void read() {}

    public void save() {}
}
