package com.codecool.lorem.models;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupTransactionModelTest {

    private GroupTransactionModel groupTransactionModel = new GroupTransactionModel(2,12,5,
                                                                            300,"done");

    @Test
    void testIsArtifactIdNotNull() {
        assertNotNull(groupTransactionModel.getArtifactId());
    }

    @Test
    void testIsStudentIdNotNull() {
        assertNotNull(groupTransactionModel.getStudentId());
    }

    @Test
    void testIsPriceNotNull() {
        assertNotNull(groupTransactionModel.getPrice());
    }

    @Nested
    class StatusFieldTests {

        @Test
        void testIsStatusIsNotNull() {
            assertNotNull(groupTransactionModel.getStatus());
        }

        @Test
        void testSetStatus() {
            groupTransactionModel.setStatus();
            assertEquals("Marked", groupTransactionModel.getStatus());
        }
    }

    @Test
    void testToSting() {
        String expected = "ID: 2 Artifact ID: 12 Price: 300";
        assertEquals(expected, groupTransactionModel.toString());
    }
}