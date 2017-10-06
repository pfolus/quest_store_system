package com.codecool.lorem.views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainViewTest {

    private ByteArrayOutputStream byteArrayOutputStream;
    private MainView mainView;

    @BeforeEach
    public void initObjects() {
        mainView = new MainView();
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    public void printTest() {
        mainView.print("test string");
        String expected = "test string\n";
        assertEquals(expected, byteArrayOutputStream.toString());
    }

    @Test
    public void showStringTest() {
        mainView.showString("test string");
        String expected = "test string\n";
        assertEquals(expected, byteArrayOutputStream.toString());
    }
}
