package com.codecool.lorem.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArtifactModelTest {

    private ArtifactModel artifactModel = new ArtifactModel(1,"Private Mentoring", 12,"opis",500);

    @Test
    void testIsNameIsNotNull() {
        assertNotNull(artifactModel.getName());
    }

    @Test
    void testIsCategoryIdIsNotNull() {
        assertNotNull(artifactModel.getCategoryId());
    }

    @Test
    void testDescriptionIsNotNull() {
        assertNotNull(artifactModel.getDescription());
    }

    @Test
    void testPriceIsNotNull() {
        assertNotNull(artifactModel.getPrice());
    }

    @Test
    void testToSting() {
        String expected = "ID: 1 Name: Private Mentoring CategoryId: 12 Description: opis Price: 500";
        assertEquals(expected, artifactModel.toString());
    }
}