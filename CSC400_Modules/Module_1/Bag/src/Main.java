public class Main {
    public static void main(String[] args) {

        // Create a Bag object called bag //
        Bag<String> bag = new Bag<>();

        // Add 5 items into bag //
        bag.add("puck");
        bag.add("stick");
        bag.add("helmet");
        bag.add("puck");
        bag.add("glove");

        // Display contents of bag //
        System.out.println("Original Bag Contents:");
        bag.display();

        // Checks if bag contains "puck" //
        System.out.println("Does the bag contain a puck? " + bag.contains("puck"));

        // Shows number of "puck" items in bag //
        System.out.println("Number of pucks: " + bag.count("puck"));

        // Removes one occurrence of "puck" from the bag //
        bag.remove("puck");

        // Displays contents of bag after removal //
        System.out.println("\nBag Contents After Removing a Puck:");
        bag.display();

        // Checks again if bag contains "puck" //
        System.out.println("Does the bag contain a puck? " + bag.contains("puck"));

        // Checks that count has decreased after removal //
        System.out.println("Number of pucks: " + bag.count("puck"));

        // Checks if bag contains "helmet" //
        System.out.println("Does the bag contain a helmet? " + bag.contains("helmet"));

        // Checks number of "helmet" items in bag //
        System.out.println("Number of helmets: " + bag.count("helmet"));

        // Checks if bag contains "skates" //
        System.out.println("Does the bag contain skates? " + bag.contains("skates"));

        // Checks number of "skates" items in bag //
        System.out.println("Number of skates: " + bag.count("skates"));
    }
}