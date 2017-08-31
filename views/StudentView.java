public class StudentView {

    public static void showMenu() {
        String[] menuList = {"1. See My Wallet",
                             "2. Enter Artifacts Store",
                             "3. See My Experience Level",
                             "4. See Artifacts I Bought",
                             "5. See Quests I Have Finished",
                             "0. Exit"};

        for (String item : menuList) {
            System.out.print(item);
        }
    }

    public static Integer chooseOption() {
        Scanner in = new Scanner();
        System.out.println("Choose function number: ");
        id = in.nextInt();

        return id;
    }

    public static void printLevelInfo(String level) {
        System.out.println("Your current level is " + level + ".");
    }

    public static void showCoinsBalance(Integer balance) {
        System.out.println("You have " + balance + " coolcoins.");
    }
}
