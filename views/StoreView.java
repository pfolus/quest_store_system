package views;

import java.util.Scanner;

public class StoreView {


    public void showArtifact(String artifact) {
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

