public class Main {
    public static void main(String[] args) {

        // Create two Bags called bag and otherBag //
        Bag<String> bag = new Bag<>();
        Bag<String> otherBag = new Bag<>();

        // Add 5 items into bag //
        bag.add("puck");
        bag.add("stick");
        bag.add("helmet");
        bag.add("puck");
        bag.add("glove");

        // Add 6 items into otherBag //
        otherBag.add("skates");
        otherBag.add("stick");
        otherBag.add("helmet");
        otherBag.add("puck");
        otherBag.add("skates");
        otherBag.add("whistle");

        // Display contents of bag //
        System.out.println("Original Bag Contents:");
        bag.display();
        System.out.println();

        // Display contents of otherBag //
        System.out.println("Other Bag Contents:");
        otherBag.display();
        System.out.println();

        // Shows number of items in bag //
        System.out.println("Number of items in bag: " + bag.size());
        System.out.println();

        // Shows number of items in otherbag //
        System.out.println("Number of items in otherBag: " + otherBag.size());
        System.out.println();

        // Merge items in otherBag into bag //
        System.out.println("otherBag merged into bag");
        bag.merge(otherBag);
        System.out.println();

        // Display the contents of bag after merging //
        System.out.println("Merged Bag Contents:");
        bag.display();
        System.out.println();

        // Create a new Bag containing only distinct items //
        Bag<String> newDistinctBag = bag.distinct();

        // Display contents of newDistinctBag //
        System.out.println("Distinct Bag Contents:");
        newDistinctBag.display();
        System.out.println();

        // Display bag sizes of Merged Bag and Distinct Bag //
        System.out.println("Merged Bag Size: " + bag.size());
        System.out.println();
        System.out.println("Distinct Bag Size: " + newDistinctBag.size());
        System.out.println();
    }
}