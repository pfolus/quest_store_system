package models.dao;

import java.util.Iterator;

import models.BoughtArtifactModel;

public class ArtifactsBoughtDao extends Dao<BoughtArtifactModel> {

    public BoughtArtifactModel get(Integer id) {
        Iterator iter = this.getIterator();

        while (iter.hasNext()) {
            BoughtArtifactModel item = (BoughtArtifactModel) iter.next();

            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    public void read() {}

    public void save() {}

    // public BoughtArtifactModel getByStudentId(Integer id) {
    //     Iterator iter = getIterator();
    //     while (iter.hasNext()) {
    //         if (id.equals(iter.next().getStudentId()));
    //         System.out.println(iter.next());
    //     }
    // }
}
