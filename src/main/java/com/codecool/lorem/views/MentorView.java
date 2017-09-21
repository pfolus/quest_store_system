package com.codecool.lorem.views;

import java.util.Scanner;
import java.util.InputMismatchException;

public class MentorView {

    private static Scanner scan;

    public static int getIntInput(String text) {
        int integer = 0;
        boolean correctInput = false;

        while(!correctInput) {
            try {
                scan = new Scanner(System.in);
                System.out.println(text);
                integer = scan.nextInt();
                correctInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Wrong! enter integer");
                correctInput = false;
            }
        }
        return integer;
   }

   public static void showInputError() {
       System.out.println("Wrong option provided, try again!");
   }

   public static void showMenu() {
       String[] menuList = {"1. create Student", "2. add Quest", "3. add Artifact",
                "4. mark Students Done Quests", "5. mark Students Used Artifacts",
                "6. see Students Wallet", "9. quit"};

       for (String item : menuList) {
           System.out.println(item);
       }
   }
}
