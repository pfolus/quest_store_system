package com.codecool.lorem.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MentorModelTests {

    @Test
    public void testIsNameIsNotNull() {
        MentorModel mentorModel = new MentorModel(1, "Tomasz", "Kowalski", "TomKow",
                                                  "tom", "tomaszkowalski@gmail.com", 2);
        assertNotNull(mentorModel.getName());
    }

    @Test
    public void testIsSurnameIsNotNull() {
        MentorModel mentorModel = new MentorModel(1, "Tomasz", "Kowalski", "TomKow",
                "tom", "tomaszkowalski@gmail.com", 2);
        assertNotNull(mentorModel.getSurname());
    }

    @Test
    public void testIsLoginIsNotNull() {
        MentorModel mentorModel = new MentorModel(1, "Tomasz", "Kowalski", "TomKow",
                                                  "tom", "tomaszkowalski@gmail.com", 2);
        assertNotNull(mentorModel.getLogin());
    }

    @Test
    public void testIsPasswordIsNotNull() {
        MentorModel mentorModel = new MentorModel(1, "Tomasz", "Kowalski", "TomKow",
                "tom", "tomaszkowalski@gmail.com", 2);
        assertNotNull(mentorModel.getPassword());
    }

    @Test
    public void testIsEmailIsNotNull() {
        MentorModel mentorModel = new MentorModel(1, "Tomasz", "Kowalski", "TomKow",
                "tom", "tomaszkowalski@gmail.com", 2);
        assertNotNull(mentorModel.getEmail());
    }

    @Test
    public void testGetClassId() {
        MentorModel mentorModel = new MentorModel(1, "Tomasz", "Kowalski", "TomKow",
                "tom", "tomaszkowalski@gmail.com", 2);

        assertEquals(Integer.valueOf("2"), mentorModel.getClassId());
    }

    @Test
    public void testSetClassId() {
        MentorModel mentorModel = new MentorModel(1, "Tomasz", "Kowalski", "TomKow",
                "tom", "tomaszkowalski@gmail.com", 2);
        mentorModel.setClassId(3);
        assertEquals(Integer.valueOf("3"), mentorModel.getClassId());
    }
}
