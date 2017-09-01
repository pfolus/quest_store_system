package views;

import java.util.Scanner;

public class StoreView {

    public static void showMenu() {
        String[] menuList = {"1. Buy an artifact",
                             "2. Buy an artifact with teammates",
                             "0. Exit"};

        for (String item : menuList) {
            System.out.println(item);
        }
        System.out.println("");
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
}
