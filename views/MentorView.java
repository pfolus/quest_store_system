package views;

import java.util.Scanner;
import java.util.InputMismatchException;

public class MentorView {

    private static Scanner scan;

    public static int getIntInput() {
        int integer = 0;
        boolean correctInput = false;

        while(!correctInput) {
            try {
                scan = new Scanner(System.in);
                System.out.println("enter integer");
                integer = scan.nextInt();
                correctInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Wrong! enter integer");
                correctInput = false;
            }
        }
        return integer;
   }

   public static String getStringInput() {

       String input;
       scan = new Scanner(System.in);
       input = scan.nextLine();

       return input;
   }

   public static void provideQuestNameMessage() {
       System.out.print("Provide name of a quest: ");
   }

   public static void provideArtifactNameMessage() {
       System.out.print("Provide name of aa artifact: ");
   }

   public static void provideQuestPrizeMessage() {
       System.out.println("Provide required coolcoins: ");
   }

   public static void provideArtifactPriceMessage() {
       System.out.println("Provide price of an artifact: ");
   }

   public static void provideQuestDescriptionMessage() {
       System.out.print("Provide Quest's description: ");
   }

   public static void provideArtifactDescriptionMessage() {
       System.out.print("Provide Artifact's description: ");
   }

   public static void showExistLoginMessage(){
       System.out.println("Login already exists, try again!");
   }

   public static void showInputError() {
       System.out.println("Wrong option provided, try again!");
   }

   public static void showNoStudentsMessage() {
       System.out.println("There are no students in students list yet!");
   }

   public static void showMenu() {
       String[] menuList = {"1.create Student", "2.add Quest", "3. add Artifact",
                "4. mark Students Done Quests", "5. mark Students Used Artifacts",
                "6. see Students Wallet"};

       for (String item : menuList) {
           System.out.println(item);
       }
   }

   public static void showString(String string) {
       System.out.print(string);
   }

   public static void provideCategoryIdMessage() {
       System.out.println(" Pick ID of category: ");
   }

   public static void provideStudentIdMessage() {
       System.out.println(" Pick ID of student: ");
   }


}
