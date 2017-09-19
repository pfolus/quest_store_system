package com.codecool.lorem.views;

import java.util.Scanner;

public class UserView {

    public static String getName() {
        System.out.println("Provide name: ");
        String name = getStringInput();
        return name;
    }

    public static String getSurname() {
        System.out.println("Provide surname: ");
        String surname = getStringInput();
        return surname;
    }

    public static String getLogin() {
        System.out.println("Provide login: ");
        String login = getStringInput();
        return login;
    }

    public static String getEmail() {
        System.out.println("Provide email: ");
        String email = getStringInput();
        return email;
    }

    public static String getPassword() {
        System.out.println("Provide password: ");
        String password = getStringInput();
        return password;
    }

    public static String getStringInput() {
        String input;
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();

        return input;
    }

}
