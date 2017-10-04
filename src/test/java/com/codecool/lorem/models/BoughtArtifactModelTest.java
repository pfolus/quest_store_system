package com.codecool.lorem.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoughtArtifactModelTest {

    BoughtArtifactModel boughtArtifactModel = new BoughtArtifactModel(1, 2, 3, false,
                                                                      "Private mentoring", 3,"learn", 200);

    @Test
    public void testIsArtifactidIsNotNull() {
        assertNotNull(boughtArtifactModel.getArtifactId());
    }

    @Test
    public void testIsStudentidIsNotNull() {
        assertNotNull(boughtArtifactModel.getStudentId());
    }

    @Test
    public void testIsNameIsNotNull() {
        assertNotNull(boughtArtifactModel.getName());
    }

    @Test
    public void testIsDescriptionIsNotNull() {
        assertNotNull(boughtArtifactModel.getDescription());
    }

    @Test
    public void testIsPriceIsNotNull() {
        assertNotNull(boughtArtifactModel.getPrice());
    }

    @Test
    public void testIsMarkChangeState() {
        boughtArtifactModel.markAsUsed();
        assertTrue(boughtArtifactModel.isUsed() == true);
    }

    @Test
    public void testToStringStateUnused() {
        String patternString = "| Name: Private mentoring| Description: learn| Condition:  Unused| Price: 200";
        assertEquals(patternString, boughtArtifactModel.toString());
    }

    @Test
    public void testToStringStateUsed() {
        boughtArtifactModel.markAsUsed();
        String patternString = "| Name: Private mentoring| Description: learn| Condition:  Used| Price: 200";
        assertEquals(patternString, boughtArtifactModel.toString());
    }
}
