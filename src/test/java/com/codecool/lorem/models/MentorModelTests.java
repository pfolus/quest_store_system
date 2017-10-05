package com.codecool.lorem.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MentorModelTests {

    private MentorModel mentorModel;

    @BeforeEach
    public void initMentorModel() {
        this.mentorModel = new MentorModel(1, "Tomasz", "Kowalski", "TomKow",
                                            "tom", "tomaszkowalski@gmail.com", 2);
    }

    @Test
    public void testName() {
        assertEquals("Tomasz", mentorModel.getName());
    }

    @Test
    public void testSurname() {
        assertEquals("Kowalski", mentorModel.getSurname());
    }

    @Test
    public void testLogin() {
        assertEquals("TomKow", mentorModel.getLogin());
    }

    @Test
    public void testPassword() {
        assertEquals("tom", mentorModel.getPassword());
    }

    @Test
    public void testEmail() {
        assertEquals("tomaszkowalski@gmail.com", mentorModel.getEmail());
    }

    @Test
    public void testGetClassId() {
        Integer expected = 2;
        assertEquals(expected, mentorModel.getClassId());
    }

    @Test
    public void testSetClassId() {
        mentorModel.setClassId(3);
        Integer expected = 3;
        assertEquals(expected, mentorModel.getClassId());
    }
}
