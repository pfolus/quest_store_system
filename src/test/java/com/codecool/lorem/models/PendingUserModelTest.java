package com.codecool.lorem.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PendingUserModelTest {

    PendingUser pendingUser = new PendingUser(1, "student");

    @Test
    public void testGetId() {
        Integer expected = 1;
        assertEquals(expected, this.pendingUser.getId());
    }

    @Test
    public void testGetType() {
        assertEquals("student", this.pendingUser.getType());
    }
}