package views;

import java.util.Scanner;

public class MainView {

    private static Scanner scanner = new Scanner(System.in);

    public static String getLogin() {
        return scanner.nextLine();
    }

    public static String getPassword() {
        return scanner.nextLine();
    }
}
