package com.codecool.lorem.models;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArtifactCategoryModelTest {

    @Test
    public void testIsNameIsNotNull() {
        ArtifactCategoryModel artifactCategory = new ArtifactCategoryModel(1,"Private Mentoring");

        assertNotNull(artifactCategory.getName());
    }
}
