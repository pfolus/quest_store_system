package com.codecool.lorem.views;

import com.codecool.lorem.models.BoughtArtifactModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentViewTest {

    private ByteArrayOutputStream byteArrayOutputStream;
    private StudentView studentView;

    @BeforeEach
    public void initObjects() {
        studentView = new StudentView();
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    public void showMenuTest() {
        studentView.showMenu();
        String expected = "1. See My Wallet\n2. Enter Artifacts Store\n3. See My Experience Level\n" +
                                "4. See Artifacts I Bought\n5. See Quests I Have Finished\n0. Exit\n";
        assertEquals(expected, byteArrayOutputStream.toString());
    }

    @Test
    public void printWrongChoiceInfoTest() {
        studentView.printWrongChoiceInfo();
        String expected = "Wrong choice!\n";
        assertEquals(expected, byteArrayOutputStream.toString());
    }

    @Test
    public void printLevelInfoTest() {
        studentView.printLevelInfo("test level");
        String expected = "Your current level is test level.\n";
        assertEquals(expected, byteArrayOutputStream.toString());
    }

    @Test
    public void showCoinsBalanceTest() {
        studentView.showCoinsBalance(100);
        String expected = "You have 100 coolcoins.\n";
        assertEquals(expected, byteArrayOutputStream.toString());
    }

    @Test
    public void showItemsTest() {
        ArrayList<BoughtArtifactModel> masterList = new ArrayList<>();
        BoughtArtifactModel boughtArtifactModel  = new BoughtArtifactModel(1, 2, 3, false,
                "Private mentoring", 3,"learn", 200);
        masterList.add(boughtArtifactModel);
        studentView.showItems(masterList);
        String expected = "| Name: Private mentoring| Description: learn| Condition:  Unused| Price: 200\n";
        assertEquals(expected, byteArrayOutputStream.toString());
    }
}
