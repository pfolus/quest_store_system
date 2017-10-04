package com.codecool.lorem.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminModelTest {

    private AdminModel admin = new AdminModel(2, "Bartek", "Kowal", "kowal123",
            "kowal321",  "kowal@gmail.com");

    @Test
    public void testIsIdNotNull() {
        assertNotNull(admin.getId());
    }

    @Test
    public void testIsNameIsNotNull() {
        assertNotNull(admin.getName());
    }

    @Test
    public void testIsSurnameIsNotNull() {
        assertNotNull(admin.getSurname());
    }

    @Test
    public void testIsLoginIsNotNull() {
        assertNotNull(admin.getLogin());
    }

    @Test
    public void testIsPasswordIsNotNull() {
        assertNotNull(admin.getPassword());
    }

    @Test
    public void testIsEmailIsNotNull() {
        assertNotNull(admin.getEmail());
    }

    @Test
    public void testIsFullNameIsNotNull() {
        assertNotNull(admin.getFullName());
    }
}