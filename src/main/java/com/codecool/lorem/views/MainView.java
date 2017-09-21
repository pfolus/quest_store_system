package com.codecool.lorem.views;

import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class MainView {

    private static Scanner scanner = new Scanner(System.in);

    public static String getLogin() {
        System.out.print("\nEnter login: ");

        return scanner.nextLine();
    }

    public static String getPassword() {
        System.out.print("\nEnter password: ");

        return scanner.nextLine();
    }


    public static void print(String string) {
        System.out.println(string);
    }

    public static void showString(String string) {
        System.out.println(string);
    }

    public static void showLoggingInfo() {
        String[] info = new String[]{"\nLogging", ".", ".", ".", ".", ".", "."};

        try {
            for (String s:info) {
                System.out.print(s);
                TimeUnit.MILLISECONDS.sleep(500);
            }
        System.out.println();
        } catch (InterruptedException e) {
            System.out.println();
        }
    }

    public static String getString(String text) {
        String input;
        Scanner scan = new Scanner(System.in);
        System.out.println(text);
        input = scan.nextLine();

        return input;
    }
}
