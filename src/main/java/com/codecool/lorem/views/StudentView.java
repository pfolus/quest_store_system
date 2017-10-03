package com.codecool.lorem.views;

import com.codecool.lorem.models.BoughtArtifactModel;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentView {

    public static void showMenu() {
        String[] menuList = {"1. See My Wallet",
                             "2. Enter Artifacts Store",
                             "3. See My Experience Level",
                             "4. See Artifacts I Bought",
                             "5. See Quests I Have Finished",
                             "0. Exit"};

        for (String item : menuList) {
            System.out.println(item);
        }
    }

    public static Integer chooseOption() {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose function number: ");
        Integer id = in.nextInt();

        return id;
    }

    public static void printWrongChoiceInfo() {
        System.out.println("Wrong choice!");
    }

    public static void printLevelInfo(String level) {
        System.out.println("Your current level is " + level + ".");
    }

    public static void showCoinsBalance(Integer balance) {
        System.out.println("You have " + balance + " coolcoins.");
    }

    public static <T> void showItems(ArrayList<T> boughtArtifacts) {
        boughtArtifacts.forEach(System.out::println);
    }
}
