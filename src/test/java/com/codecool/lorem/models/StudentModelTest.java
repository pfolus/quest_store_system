package com.codecool.lorem.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentModelTest {

    StudentModel student = new StudentModel(2, "Bartek", "Kowal", "kowal123",
            "kowal321",  "kowal@gmail.com", 120, 2);

    @Test
    public void testIsIdIsNotNull() {
        assertNotNull(student.getId());
    }

    @Test
    public void testIsNameIsNotNull() {
        assertNotNull(student.getName());
    }

    @Test
    public void testIsSurnameIsNotNull() {
        assertNotNull(student.getSurname());
    }

    @Test
    public void testIsLoginIsNotNull() {
        assertNotNull(student.getLogin());
    }

    @Test
    public void testIsPasswordIsNotNull() {
        assertNotNull(student.getPassword());
    }

    @Test
    public void testIsEmailIsNotNull() {
        assertNotNull(student.getEmail());
    }

    @Test
    public void testIsFullNameIsNotNull() {
        assertNotNull(student.getFullName());
    }

    @Test
    public void testIsScoreIsNotNull() {
        assertNotNull(student.getScore());
    }

    @Test
    public void testIsClassIdIsNotNull() {
        assertNotNull(student.getClassId());
    }
}