package com.codecool.lorem.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserModelTest {


    @Test
    public void testIsIdIsNotNull() {
        UserModel user = new AdminModel(2, "Bartek", "Kowal", "kowal123",
                "kowal321",  "kowal@gmail.com");
        assertNotNull(user.getId());
    }

    @Test
    public void testIsNameIsNotNull() {
        UserModel user = new AdminModel(2, "Bartek", "Kowal", "kowal123",
                "kowal321",  "kowal@gmail.com");
        assertNotNull(user.getName());
    }

    @Test
    public void testIsSurnameIsNotNull() {
        UserModel user = new UserModel(2, "Bartek", "Kowal", "kowal123",
                "kowal321",  "kowal@gmail.com");
        assertNotNull(user.getSurname());
    }

    @Test
    public void testIsLoginIsNotNull() {
        UserModel user = new UserModel(2, "Bartek", "Kowal", "kowal123",
                "kowal321",  "kowal@gmail.com");
        assertNotNull(user.getLogin());
    }

    @Test
    public void testIsPasswordIsNotNull() {
        UserModel user = new UserModel(2, "Bartek", "Kowal", "kowal123",
                "kowal321",  "kowal@gmail.com");
        assertNotNull(user.getPassword());
    }

    @Test
    public void testIsEmailIsNotNull() {
        UserModel user = new UserModel(2, "Bartek", "Kowal", "kowal123",
                "kowal321",  "kowal@gmail.com");
        assertNotNull(user.getEmail());
    }

    @Test
    public void testIsFullNameIsNotNull() {
        UserModel user = new UserModel(2, "Bartek", "Kowal", "kowal123",
                "kowal321",  "kowal@gmail.com");
        assertNotNull(user.getFullName());
    }

    @Test
    public void testSetPassword() {
        UserModel user = new UserModel(2, "Bartek", "Kowal", "kowal123",
                "kowal321",  "kowal@gmail.com");
        user.setPassword("pass123");
        assertEquals("pass123", user.getPassword());
    }

    @Test
    public void testSetEmail() {
        UserModel user = new UserModel(2, "Bartek", "Kowal", "kowal123",
                "kowal321",  "kowal@gmail.com");
        user.setEmail("random@gmail.com");
        assertEquals("random@gmail.com", user.getEmail());
    }

    @Test
    public void testToString() {
        UserModel user = new UserModel(2, "Bartek", "Kowal", "kowal123",
                "kowal321",  "kowal@gmail.com");
        String expected = "ID: 2 Name: Bartek Surname: Kowal Login: kowal123 Email: kowal@gmail.com";
        assertEquals(expected , user.toString());
    }


}