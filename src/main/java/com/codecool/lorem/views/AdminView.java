package com.codecool.lorem.views;

import java.util.Scanner;

public class AdminView {

    public static void showMenu() {
        String[] menuList = {"\n1. Create mentor",
                "2. Create class",
                "3. Edit mentor's profile",
                "4. Show mentor's info",
                "5. Create experience level",
                "0. Exit\n"};

        for (String item : menuList) {
            System.out.println(item);
        }
    }

    public static String getOption() {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose option: ");
        return in.nextLine();
    }
}
