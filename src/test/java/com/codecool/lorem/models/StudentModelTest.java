package com.codecool.lorem.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentModelTest {

    @Test
    public void testIsIdIsNotNull() {
        StudentModel student = new StudentModel(2, "Bartek", "Kowal", "kowal123",
                "kowal321",  "kowal@gmail.com", 120, 2);
        assertNotNull(student.getId());
    }

    @Test
    public void testIsNameIsNotNull() {
        StudentModel student = new StudentModel(2, "Bartek", "Kowal", "kowal123",
                "kowal321",  "kowal@gmail.com", 120, 2);
        assertNotNull(student.getName());
    }

    @Test
    public void testIsSurnameIsNotNull() {
        StudentModel student = new StudentModel(2, "Bartek", "Kowal", "kowal123",
                "kowal321",  "kowal@gmail.com", 120, 2);
        assertNotNull(student.getSurname());
    }

    @Test
    public void testIsLoginIsNotNull() {
        StudentModel student = new StudentModel(2, "Bartek", "Kowal", "kowal123",
                "kowal321",  "kowal@gmail.com", 120, 2);
        assertNotNull(student.getLogin());
    }

    @Test
    public void testIsPasswordIsNotNull() {
        StudentModel student = new StudentModel(2, "Bartek", "Kowal", "kowal123",
                "kowal321",  "kowal@gmail.com", 120, 2);
        assertNotNull(student.getPassword());
    }

    @Test
    public void testIsEmailIsNotNull() {
        StudentModel student = new StudentModel(2, "Bartek", "Kowal", "kowal123",
                "kowal321",  "kowal@gmail.com", 120, 2);
        assertNotNull(student.getEmail());
    }

    @Test
    public void testIsFullNameIsNotNull() {
        StudentModel student = new StudentModel(2, "Bartek", "Kowal", "kowal123",
                "kowal321",  "kowal@gmail.com", 120, 2);
        assertNotNull(student.getFullName());
    }

    @Test
    public void testIsScoreIsNotNull() {
        StudentModel student = new StudentModel(2, "Bartek", "Kowal", "kowal123",
                "kowal321",  "kowal@gmail.com", 120, 2);
        assertNotNull(student.getScore());
    }

    @Test
    public void testIsClassIdIsNotNull() {
        StudentModel student = new StudentModel(2, "Bartek", "Kowal", "kowal123",
                "kowal321",  "kowal@gmail.com", 120, 2);
        assertNotNull(student.getClassId());
    }

}