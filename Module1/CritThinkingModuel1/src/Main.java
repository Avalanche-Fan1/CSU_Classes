//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

class Restaurant {
    public static void main (String [] args) {

        String restaurantName;      // Declare Variables //
        String restaurantStreet;
        String restaurantCityStateZip;


        // Create input scanner to gather data from user //

        Scanner scnr = new Scanner(System.in);

        // Get name from user  restaurantName //

        System.out.print("Enter Name of Restaurant: ");
        restaurantName = scnr.nextLine();

        // Get street from user into restaurantStreet //

        System.out.print("Enter Street Address of Restaurant: ");
        restaurantStreet = scnr.nextLine();

        // Get City, State and Zip from user into restaurantCityStateZip //

        System.out.print("Enter City, State, and Zip of Restaurant: ");
        restaurantCityStateZip = scnr.nextLine();

        // Display each Variable, one on each line //
        System.out.println();
        System.out.println(restaurantName);
        System.out.println(restaurantStreet);
        System.out.println(restaurantCityStateZip);
    }
}
