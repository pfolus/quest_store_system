package com.codecool.lorem.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LevelModelTest {

    LevelModel level = new LevelModel(1, 12, "medium");

    @Test
    public void testIsNameIsNotNull() {
        assertNotNull(level.getName());
    }

    @Test
    public void testIsRequiredScoreIsNotNull() {
        assertNotNull(level.getRequiredScore());
    }

}