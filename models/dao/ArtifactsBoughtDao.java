package models.dao;

import models.BoughtArtifactModel;

public class ArtifactsBoughtDao extends Dao<BoughtArtifactModel> {

    public ArtifactBoughtModel get(Integer id) {
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
