package com.codecool.lorem.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestModelTest {

    QuestModel quest = new QuestModel(3, "attendance", 3, "nothing", 240);

    @Test
    public void testIsPrizeIsNotNull() {
        assertNotNull(quest.getPrize());
    }

    @Test
    public void testToString() {
        String expected = "3. attendance";
        assertEquals(expected , quest.toString());
    }

}