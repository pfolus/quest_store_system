package com.codecool.lorem.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestCategoryModelTest {

    QuestCategoryModel questCategory = new QuestCategoryModel(2, "sport");

    @Test
    public void testGetName() {
        assertEquals("sport", questCategory.getName());
    }

    @Test
    public void testToString() {
        String expected = "2. sport";
        assertEquals(expected , questCategory.toString());
    }
}