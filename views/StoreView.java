package views;

import java.util.Scanner;

public class StoreView {


    public static void showArtifact(String artifact) {
        System.out.println(artifact);
    }

    public static Integer chooseArtifactId() {
        Scanner in = new Scanner();
        System.out.println("Provide artifact id: ");
        id = in.nextInt();

        return id;
    }

    public void printWrongChoiceInfo() {
        System.out.println("Wrong choice.");
    }

    public void notEnoughMoneyInfo() {
        System.out.println("You can't buy this artifact. You do not have enough coolcoins.");
    }
}
