package com.codecool.lorem.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentModelTest {

    StudentModel student = new StudentModel(2, "Bartek", "Kowal", "kowal123",
            "kowal321",  "kowal@gmail.com", 120, 2);

    @Test
    public void testGetId() {
        Integer expected = 2;
        assertEquals(expected, student.getId());
    }

    @Test
    public void testGetName() {
        assertNotNull("Bartek", student.getName());
    }

    @Test
    public void testGetSurname() {
        assertEquals("Kowal", student.getSurname());
    }

    @Test
    public void testGetLogin() {
        assertEquals("kowal123", student.getLogin());
    }

    @Test
    public void testGetPassword() {
        assertEquals("kowal321", student.getPassword());
    }

    @Test
    public void testGetEmail() {
        assertEquals("kowal@gmail.com", student.getEmail());
    }

    @Test
    public void testGetFullName() {
        assertEquals("Bartek Kowal", student.getFullName());
    }

    @Test
    public void testGetScore() {
        Integer expected = 120;
        assertEquals(expected, student.getScore());
    }

    @Test
    public void testGetClass() {
        Integer expected = 2;
        assertEquals(expected, student.getClassId());
    }
}