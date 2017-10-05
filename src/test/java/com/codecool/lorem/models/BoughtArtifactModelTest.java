package com.codecool.lorem.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoughtArtifactModelTest {

    private BoughtArtifactModel boughtArtifactModel;

    @BeforeEach
    public void initBoughtArtifactModel() {
        this.boughtArtifactModel  = new BoughtArtifactModel(1, 2, 3, false,
                                                    "Private mentoring", 3,"learn", 200);
    }

    @Test
    public void testGetArtifactid() {
        Integer expected =2;
        assertEquals(expected, this.boughtArtifactModel.getArtifactId());
    }

    @Test
    public void testGetStudentid() {
        Integer expected = 3;
        assertEquals(expected, this.boughtArtifactModel.getStudentId());
    }

    @Test
    public void testGetName() {
        assertEquals("Private mentoring", this.boughtArtifactModel.getName());
    }

    @Test
    public void testGetDescription() {
        assertEquals("learn", boughtArtifactModel.getDescription());
    }

    @Test
    public void testGetPrice() {
        Integer expected = 200;
        assertEquals(expected, this.boughtArtifactModel.getPrice());
    }

    @Test
    public void testIsMarkChangeState() {
        this.boughtArtifactModel.markAsUsed();
        assertTrue(this.boughtArtifactModel.isUsed() == true);
    }

    @Test
    public void testToStringStateUnused() {
        String patternString = "| Name: Private mentoring| Description: learn| Condition:  Unused| Price: 200";
        assertEquals(patternString, this.boughtArtifactModel.toString());
    }

    @Test
    public void testToStringStateUsed() {
        boughtArtifactModel.markAsUsed();
        String patternString = "| Name: Private mentoring| Description: learn| Condition:  Used| Price: 200";
        assertEquals(patternString, this.boughtArtifactModel.toString());
    }
}
