package com.codecool.lorem.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WalletModelTest {

    WalletModel walletModel = new WalletModel(1, 2, 3);

    @Test
    public void testBalance() {
        Integer expected = 2;
        assertEquals(expected, walletModel.getBalance());
    }

    @Test
    public void testStudentid() {
        Integer expected = 3;
        assertEquals(expected, walletModel.getStudentId());
    }

    @Test
    public void testReduceBalance() {
        walletModel.reduceBalance(1);
        assertTrue(walletModel.getBalance() == 1);
    }

    @Test
    public void testIncreaseBalance() {
        walletModel.increaseBalance(1);
        assertTrue(walletModel.getBalance() == 3);
    }

}
