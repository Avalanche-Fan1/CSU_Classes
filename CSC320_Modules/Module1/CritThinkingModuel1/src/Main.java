//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

class Restaurant {
    public static void main (String [] args) {

        String restaurantName;      // Declare Variables //
        String restaurantStreet;
        String restaurantCity;
        String restaurantState;
        Integer restaurantZip;



        // Create input scanner to gather data from user //

        Scanner scnr = new Scanner(System.in);

        // Get name from user  restaurantName //

        System.out.print("Enter Name of Restaurant: ");
        restaurantName = scnr.nextLine();

        // Get street from user into restaurantStreet //

        System.out.print("Enter Street Address of Restaurant: ");
        restaurantStreet = scnr.nextLine();

        // Get City, State and Zip from user into restaurantCityStateZip //

        System.out.print("Enter City of Restaurant: ");
        restaurantCity = scnr.nextLine();
        System.out.print("Enter State of Restaurant: ");
        restaurantState = scnr.nextLine();
        System.out.print("Enter Zip of Restaurant: ");
        restaurantZip = scnr.nextInt();

        // Display each Variable, one on each line //
        System.out.println();
        System.out.println(restaurantName);
        System.out.println(restaurantStreet);
        System.out.println(restaurantCity + ", " + restaurantState + " " + restaurantZip);
    }
}
