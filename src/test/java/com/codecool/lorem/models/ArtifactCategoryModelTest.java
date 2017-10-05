package com.codecool.lorem.models;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class ArtifactCategoryModelTest {

    private ArtifactCategoryModel artifactCategory = new ArtifactCategoryModel(1,"Private Mentoring");
    
    @Test
    public void testGetName() {
        assertEquals("Private Mentoring", artifactCategory.getName());
    }

    @Test
    public void testToString() {
        assertEquals("1. Private Mentoring" , this.artifactCategory.toString());
    }
}
