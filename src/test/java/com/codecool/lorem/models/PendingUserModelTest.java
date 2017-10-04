package com.codecool.lorem.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PendingUserModelTest {

    PendingUser pendingUser = new PendingUser(1, "student");

    @Test
    public void testIsIdIsNotNull() {
        assertNotNull(pendingUser.getId());
    }

    @Test
    public void testIsTypeIsNotNull() {
        assertNotNull(pendingUser.getType());
    }
}