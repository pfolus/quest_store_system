package com.codecool.lorem.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LevelModelTest {

    LevelModel level = new LevelModel(1, 12, "medium");

    @Test
    public void testGetName() {
        assertEquals("medium", level.getName());
    }

    @Test
    public void testGetRequiredScore() {
        Integer expected = 12;
        assertEquals(expected, level.getRequiredScore());
    }

}