package com.codecool.lorem.views;

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
}
