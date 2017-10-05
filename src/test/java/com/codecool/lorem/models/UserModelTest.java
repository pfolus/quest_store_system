package com.codecool.lorem.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserModelTest {

    UserModel user;

    @BeforeEach
    public void initUser() {
        this.user = new UserModel(2, "Bartek", "Kowal", "kowal123",
                "kowal321",  "kowal@gmail.com");
    }

    @Test
    public void testGetPassword() {
        assertEquals("kowal321", this.user.getPassword());
    }

    @Test
    public void testSetPassword() {
        user.setPassword("pass123");
        assertEquals("pass123", this.user.getPassword());
    }

    @Test
    public void testGetEmail() {
        assertEquals("kowal@gmail.com", this.user.getEmail());
    }

    @Test
    public void testSetEmail() {
        user.setEmail("random@gmail.com");
        assertEquals("random@gmail.com", this.user.getEmail());
    }

    @Test
    public void testToString() {
        String expected = "ID: 2 Name: Bartek Surname: Kowal Login: kowal123 Email: kowal@gmail.com";
        assertEquals(expected , this.user.toString());
    }
}