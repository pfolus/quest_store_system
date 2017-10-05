package com.codecool.lorem.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WalletModelTest {

    WalletModel walletModel;

    @BeforeEach
    public void initMentorModel() {
        this.walletModel = new WalletModel(1, 2, 3);
    }
    @Test
    public void testGetBalance() {
        Integer expected = 2;
        assertEquals(expected, this.walletModel.getBalance());
    }

    @Test
    public void testGetStudentid() {
        Integer expected = 3;
        assertEquals(expected, this.walletModel.getStudentId());
    }

    @Test
    public void testReduceBalance() {
        this.walletModel.reduceBalance(1);
        assertTrue(this.walletModel.getBalance() == 1);
    }

    @Test
    public void testIncreaseBalance() {
        this.walletModel.increaseBalance(1);
        assertTrue(this.walletModel.getBalance() == 3);
    }
}
