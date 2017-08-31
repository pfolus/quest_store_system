package views;

import java.util.Scanner;

public class UserView {

    public static String getName() {
        System.out.println("Provide name: ");
        String name = getStringInput();
        return name;
    }
