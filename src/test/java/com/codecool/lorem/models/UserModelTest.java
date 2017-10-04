package com.codecool.lorem.models;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserModelTest {


    private UserModel user = new AdminModel(2, "Bartek", "Kowal", "kowal123",
            "kowal321",  "kowal@gmail.com");

    @Test
    public void testIsIdIsNotNull() {
        assertNotNull(user.getId());
    }

    @Test
    public void testIsNameIsNotNull() {
        assertNotNull(user.getName());
    }

    @Test
    public void testIsSurnameIsNotNull() {
        assertNotNull(user.getSurname());
    }

    @Test
    public void testIsLoginIsNotNull() {
        assertNotNull(user.getLogin());
    }

    @Test
    public void testIsFullNameIsNotNull() {
        assertNotNull(user.getFullName());
    }

    @Nested
    class PasswordFieldTests {

        @Test
        public void testIsPasswordIsNotNull() {
            assertNotNull(user.getPassword());
        }

        @Test
        public void testSetPassword() {
            user.setPassword("pass123");
            assertEquals("pass123", user.getPassword());
        }

    }

    @Nested
    class EmailFieldTests {

        @Test
        public void testIsEmailIsNotNull() {
            assertNotNull(user.getEmail());
        }

        @Test
        public void testSetEmail() {
            user.setEmail("random@gmail.com");
            assertEquals("random@gmail.com", user.getEmail());
        }
    }

    @Test
    public void testToString() {
        String expected = "ID: 2 Name: Bartek Surname: Kowal Login: kowal123 Email: kowal@gmail.com";
        assertEquals(expected , user.toString());
    }


}