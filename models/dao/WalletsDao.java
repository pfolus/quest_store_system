package models.dao;

import java.util.Iterator;
import models.WalletModel;

public class WalletsDao extends Dao<WalletModel> {

    public WalletModel get(Integer id) {
        Iterator iter = this.getIterator();

        while (iter.hasNext()) {
            WalletModel user = (WalletModel) iter.next();

            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public void read() {}

    public void save() {}

    public WalletModel getByStudentId(Integer id) {
        Iterator iter = this.getIterator();

        while (iter.hasNext()) {
            WalletModel wallet = (WalletModel) iter.next();

            if (wallet.getStudentId().equals(id)) {
                return wallet;
            }
        }
        return null;
    }
}
