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

   public static void showInputError() {
       System.out.println("Wrong option provided, try again!");
   }

   public static void showMenu() {
       String[] menuList = {"1.create Student", "2.add Quest", "3. add Artifact",
                "4. mark Students Done Quests", "5. mark Students Used Artifacts",
                "6. see Students Wallet"};

       for (String item : menuList) {
           System.out.print(item);
       }
   }


}
