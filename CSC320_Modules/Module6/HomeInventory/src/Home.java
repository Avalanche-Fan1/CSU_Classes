import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

public class Home {

    private int squareFeet;
    private String address;
    private String city;
    private String state;
    private int zipCode;
    private String modelName;
    private String saleStatus;

    private static final ArrayList<Home> homes = new ArrayList<>();
    private static final Set<String> VALID_STATUSES =
            Set.of("sold", "available", "under contract");

    // Parameterized Constructor //
    public Home(int squareFeet, String address, String city, String state,
                int zipCode, String modelName, String saleStatus) {
        try {
            this.squareFeet = squareFeet;
            this.address = address;
            this.city = city;
            this.state = state;
            this.zipCode = zipCode;
            this.modelName = modelName;
            this.saleStatus = saleStatus;
        } catch (Exception e) {
            System.out.println("Constructor failure: " + e.getMessage());
        }
    }

    // Add Home //
    public static String addHome(int squareFeet, String address, String city,
                                 String state, int zipCode,
                                 String modelName, String saleStatus) {
        try {
            if (!isValidStatus(saleStatus)) {
                return "Invalid sale status.";
            }

            Home newHome = new Home(squareFeet, address, city, state, zipCode, modelName, saleStatus);
            homes.add(newHome);
            return "Home added successfully.";
        } catch (Exception e) {
            return "Failed to add home: " + e.getMessage();
        }
    }

    // Remove Home //
    public static String removeHome(int index) {
        try {
            if (index >= 0 && index < homes.size()) {
                homes.remove(index);
                return "Home removed successfully.";
            }
            return "Invalid home number.";
        } catch (Exception e) {
            return "Failed to remove home: " + e.getMessage();
        }
    }

    // Update Home //
    public static String updateHomeStatus(int index, String saleStatus) {
        try {
            if (!isValidStatus(saleStatus)) {
                return "Invalid sale status.";
            }

            if (index >= 0 && index < homes.size()) {
                homes.get(index).saleStatus = saleStatus;
                return "Home updated successfully.";
            }
            return "Invalid home number.";
        } catch (Exception e) {
            return "Failed to update home: " + e.getMessage();
        }
    }

    // List Homes //
    public static String listHomes() {
        try {
            // Method prints each home's details and returns a status message for caller feedback.
            if (homes.isEmpty()) {
                return "No homes in inventory.";
            }

            for (int i = 0; i < homes.size(); i++) {

                Home h = homes.get(i);

                System.out.println("\nHome #" + (i + 1));
                System.out.println("Square Feet: " + h.squareFeet);
                System.out.println("Address: " + h.address);
                System.out.println("City: " + h.city);
                System.out.println("State: " + h.state);
                System.out.println("Zip Code: " + h.zipCode);
                System.out.println("Model Name: " + h.modelName);
                System.out.println("Sale Status: " + h.saleStatus);
            }

            return "Homes listed successfully.";
        } catch (Exception e) {
            return "Failed to list homes: " + e.getMessage();
        }
    }

    public static boolean hasHomes() {
        try {
            return !homes.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    public static int getHomeCount() {
        try {
            return homes.size();
        } catch (Exception e) {
            return 0;
        }
    }

    // Print Homes to File
    public static String printHomesToFile() {

        try (FileWriter writer = new FileWriter("Home.txt")) {

            for (Home h : homes) {

                writer.write("Square Feet: " + h.squareFeet + "\n");
                writer.write("Address: " + h.address + "\n");
                writer.write("City: " + h.city + "\n");
                writer.write("State: " + h.state + "\n");
                writer.write("Zip Code: " + h.zipCode + "\n");
                writer.write("Model Name: " + h.modelName + "\n");
                writer.write("Sale Status: " + h.saleStatus + "\n");
                writer.write("----------------------\n");

            }

            return "File printed to Home.txt";

        }
        catch (IOException e) {
            return "Failed to print file: " + e.getMessage();
        }
    }

    private static boolean isValidStatus(String status) {
        try {
            return status != null && VALID_STATUSES.contains(status.toLowerCase());
        } catch (Exception e) {
            return false;
        }
    }
}
sout