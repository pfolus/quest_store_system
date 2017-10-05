package com.codecool.lorem.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArtifactModelTest {

    private ArtifactModel artifactModel = new ArtifactModel(1,"Private Mentoring", 12,"opis",500);

    @Test
    void testGetName() {
        assertEquals("Private Mentoring", artifactModel.getName());
    }

    @Test
    void testGetCategoryId() {
        Integer expected = 12;
        assertEquals(expected, artifactModel.getCategoryId());
    }

    @Test
    void testGetDescription() {
        assertEquals("opis", artifactModel.getDescription());
    }

    @Test
    void testGetPrice() {
        Integer expected = 500;
        assertEquals(expected, artifactModel.getPrice());
    }

    @Test
    void testToSting() {
        String expected = "ID: 1 Name: Private Mentoring CategoryId: 12 Description: opis Price: 500";
        assertEquals(expected, artifactModel.toString());
    }
}