package com.codecool.lorem.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoneQuestModelTest {

    DoneQuestModel doneQuest = new DoneQuestModel(1, "mentoring", 2, "take mentoring",
            100,10, 12);

    @Test
    public void testIsGetQuestIdIsNotNull() {
        assertNotNull(doneQuest.getQuestId());
    }

    @Test
    public void testIsGetIdIsNotNull() {
        assertNotNull(doneQuest.getId());
    }

    @Test
    public void testIsStudentIdIsNotNull() {
        assertNotNull(doneQuest.getStudentId());
    }

}