package com.codecool.lorem.dao;

import java.util.Iterator;

import com.codecool.lorem.models.WalletModel;

public class WalletsDao extends Dao<WalletModel> {

    public WalletModel getById(Integer id) {
        for (WalletModel wallet : getItems()) {
            if (wallet.getId().equals(id)) {
                return wallet;
            }
        }
        return null;
    }
}
