package com.codecool.lorem.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoneQuestModelTest {

    DoneQuestModel doneQuest = new DoneQuestModel(1, "mentoring", 2, "take mentoring",
                                                  100,10, 12);

    @Test
    public void testGetQuestId() {
        Integer expected = 10;
        assertEquals(expected, doneQuest.getQuestId());
    }

    @Test
    public void testGetId() {
        Integer expected = 1;
        assertEquals(expected, doneQuest.getId());
    }

    @Test
    public void testGetStudentId() {
        Integer expected = 12;
        assertEquals(expected, doneQuest.getStudentId());
    }

}