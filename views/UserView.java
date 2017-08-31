package views;

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

