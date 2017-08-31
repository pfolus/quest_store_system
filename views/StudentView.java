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

    public static void showCoinsBalance(Integer balance) {
        System.out.println("You have " + balance + " coolcoins.");
    }
}
