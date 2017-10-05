package com.codecool.lorem.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupTransactionModelTest {

    private GroupTransactionModel groupTransactionModel;

    @BeforeEach
    void initGroupTransactionModel() {
        this.groupTransactionModel = new GroupTransactionModel(2,12,5,
                                300,"done");
    }
    @Test

    void testGetArtifactId() {
        Integer expected = 12;
        assertEquals(expected, this.groupTransactionModel.getArtifactId());
    }

    @Test
    void testGetStudentId() {
        Integer expected = 5;
        assertEquals(expected, this.groupTransactionModel.getStudentId());
    }

    @Test
    void testGetPrice() {
        Integer expected = 300;
        assertEquals(expected, this.groupTransactionModel.getPrice());
    }

    @Test
    void testGetStatus() {
        assertEquals("done", this.groupTransactionModel.getStatus());
    }

    @Test
    void testSetStatus() {
        this.groupTransactionModel.setStatus();
        assertEquals("Marked", this.groupTransactionModel.getStatus());
    }

    @Test
    void testToSting() {
        String expected = "ID: 2 Artifact ID: 12 Price: 300";
        assertEquals(expected, this.groupTransactionModel.toString());
    }
}