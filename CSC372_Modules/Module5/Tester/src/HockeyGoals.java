public class HockeyGoals {

    public static int totalGoals(int games) {

        // Base case
        if (games == 1) {
            return 1;
        }

        // Recursive case
        return games + totalGoals(games - 1);
    }

    public static void main(String[] args) {
        int games = 5;
        System.out.println("Total goals after " + games + " games: " + totalGoals(games));
    }
}

