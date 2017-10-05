package com.codecool.lorem.models;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArtifactCategoryModelTest {

    private ArtifactCategoryModel artifactCategory = new ArtifactCategoryModel(1,"Private Mentoring");

    @Test
    public void testName() {
        String expected = "Private Mentoring";
        assertEquals(expected, artifactCategory.getName());
    }
}
