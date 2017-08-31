package models.dao;

import java.util.Iterator;
import models.WalletModel;

public class WalletsDao extends Dao<WalletModel> {

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
