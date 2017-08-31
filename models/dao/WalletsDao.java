package models.dao;

import models.WalletModel;

public class WalletsDao extends Dao<WalletModel> {

    public WalletModel get(Integer id) {
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

    public WalletModel getByStudentId(Integer id) {
        Iterator iter = this.getIterator();

        while (iter.hasNext()) {
            if (iter.next().getStudentId().equals(id)) {
                return iter.next();
            }
        }
    }
}
