package com.codecool.lorem.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminModelTest {

    private AdminModel admin = new AdminModel(2, "Bartek", "Kowal", "kowal123",
            "kowal321",  "kowal@gmail.com");

    @Test
    public void testGetId() {
        Integer expected = 2;
        assertEquals(expected, admin.getId());
    }

    @Test
    public void testGetName() {
        assertEquals("Bartek", admin.getName());
    }

    @Test
    public void testGetSurname() {
        assertEquals("Kowal", admin.getSurname());
    }

    @Test
    public void testGetLogin() {
        assertEquals("kowal123", admin.getLogin());
    }

    @Test
    public void testGetPassword() {
        assertEquals("kowal321", admin.getPassword());
    }

    @Test
    public void testGetEmail() {
        assertEquals("kowal@gmail.com", admin.getEmail());
    }

    @Test
    public void testGetFullName() { assertEquals("Bartek Kowal", admin.getFullName()); }
}