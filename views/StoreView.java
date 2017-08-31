package views;

import java.util.Scanner;

public class StoreView {


    public static void showArtifact(String artifact) {
        System.out.println(artifact);
    }

    public Integer chooseArtifactId() {
        Integer id;
        boolean isCorrect = false;

        while(!isCorrect) {

            try {
                Scanner in = new Scanner();
                System.out.println("Provide artifact id: ");
                id = in.nextInt();
                isCorrect = true;
            } catch (InputMismatchException e) {
                printWrongChoiceInfo();
            }
        }
        return id;
    }

    public void printWrongChoiceInfo() {
        System.out.println("Wrong choice.");
    }

    public void notEnoughMoneyInfo() {
        System.out.println("You can't buy this artifact. You do not have enough coolcoins.");
    }
}
