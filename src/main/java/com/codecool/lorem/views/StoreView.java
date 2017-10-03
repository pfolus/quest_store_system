package com.codecool.lorem.views;

import com.codecool.lorem.models.ArtifactModel;
import com.codecool.lorem.models.GroupTransactionModel;
import com.codecool.lorem.models.StudentModel;

import java.util.ArrayList;
import java.util.Scanner;

public class StoreView {

    public static void showMenu() {
        String[] menuList = {"1. Buy an artifact",
                             "2. Buy an artifact with teammates",
                             "3. Manage pending transactions",
                             "0. Exit"};

        for (String item : menuList) {
            System.out.println(item);
        }
        System.out.println("");
    }
    public static void showArtifacts(ArrayList<ArtifactModel> artifacts) {
        artifacts.forEach(System.out::println);
    }

    public static void showArtifact(String artifact) {
        System.out.println(artifact);
    }

    public static Integer chooseArtifactId() {
        Scanner in = new Scanner(System.in);
        System.out.println("Provide artifact id: ");
        Integer id = in.nextInt();

        return id;
    }

    public static Integer chooseTransactionId() {
        Scanner in = new Scanner(System.in);
        System.out.println("Provide transaction id or type 0 to exit: ");
        Integer id = in.nextInt();

        return id;
    }

    public static Integer chooseOption() {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose function number: ");
        Integer id = in.nextInt();

        return id;
    }

    public static void printWrongChoiceInfo() {
        System.out.println("Wrong choice.");
    }

    public static void notEnoughMoneyInfo() {
        System.out.println("You can't buy this artifact. You do not have enough coolcoins.");
    }

    public static void itemBoughtSuccesfully() {
        System.out.println("You bought an artifact.");
    }

    public static void showStudents(ArrayList<StudentModel> students, StudentModel studentToSkip) {
        for (StudentModel s : students) {
            if (!(s.getId().equals(studentToSkip.getId()))) {
                System.out.println(s);
            }
        }
    }

    public static void showTransactions(ArrayList<GroupTransactionModel> transactions) {
        for (GroupTransactionModel transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public static Integer acceptOrDeclineTransaction(GroupTransactionModel transaction) {
        System.out.println(transaction);

        Scanner in = new Scanner(System.in);
        System.out.println("Type 0 to decline or 1 to accept: ");
        Integer choice = in.nextInt();

        return choice;
    }
}
