package com.codecool.lorem.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminModelTest {

    @Test
    public void testIsNameIsNotNull() {
        AdminModel admin = new AdminModel(2, "Bartek", "Kowal", "kowal123",
                                          "kowal321",  "kowal@gmail.com");
        assertNotNull(admin.getName());
    }

    @Test
    public void testIsSurnameIsNotNull() {
        AdminModel admin = new AdminModel(2, "Bartek", "Kowal", "kowal123",
                "kowal321",  "kowal@gmail.com");
        assertNotNull(admin.getSurname());
    }

    @Test
    public void testIsLoginIsNotNull() {
        AdminModel admin = new AdminModel(2, "Bartek", "Kowal", "kowal123",
                "kowal321",  "kowal@gmail.com");
        assertNotNull(admin.getLogin());
    }

    @Test
    public void testIsPasswordIsNotNull() {
        AdminModel admin = new AdminModel(2, "Bartek", "Kowal", "kowal123",
                "kowal321",  "kowal@gmail.com");
        assertNotNull(admin.getPassword());
    }

    @Test
    public void testIsEmailIsNotNull() {
        AdminModel admin = new AdminModel(2, "Bartek", "Kowal", "kowal123",
                "kowal321",  "kowal@gmail.com");
        assertNotNull(admin.getEmail());
    }


}