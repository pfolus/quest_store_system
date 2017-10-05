package com.codecool.lorem.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClassModelTest {

    private ClassModel classModel = new ClassModel(10, "krk17");

    @Test
    public void testGetName() {
        assertEquals("krk17", classModel.getName());
    }

    @Test
    public void toStringTest() {
        assertEquals("10. krk17", classModel.toString());
    }
}