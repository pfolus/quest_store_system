package com.codecool.lorem.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WalletModelTest {

    WalletModel walletModel = new WalletModel(1, 2, 3);

    @Test
    public void testIsBalanceIsNotNull() {
        assertNotNull(walletModel.getBalance());
    }

    @Test
    public void testIsStudentidIsNotNull() {
        assertNotNull(walletModel.getStudentId());
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
