import java.util.Scanner;
import java.lang.Integer;

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

   public static void showExistLoginMessage(){
       System.out.println("Login already exists, try again!");
   }
