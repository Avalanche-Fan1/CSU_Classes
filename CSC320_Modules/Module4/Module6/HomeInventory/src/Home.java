import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class Home {
    // Attributes
    private int id;
    private int squareFeet;
    private String address;
    private String city;
    private String state;
    private int zipCode;
    private String modelName;
    private String saleStatus;

    // Static inventory and ID tracker
    private static ArrayList<Home> inventory = new ArrayList<>();
    private static int nextID = 1;

    // Constructor
    public Home(int squareFeet, String address, String city, String state,
                int zipCode, String modelName, String saleStatus) {
        this.id = nextID++;
        this.squareFeet = squareFeet;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.modelName = modelName;
        this.saleStatus = saleStatus;
    }

    // Getters and setters
    public int getId() { return id; }
    public int getSquareFeet() { return squareFeet; }
    public void setSquareFeet(int squareFeet) { this.squareFeet = squareFeet; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
    public int getZipCode() { return zipCode; }
    public void setZipCode(int zipCode) { this.zipCode = zipCode; }
    public String getModelName() { return modelName; }
    public void setModelName(String modelName) { this.modelName = modelName; }
    public String getSaleStatus() { return saleStatus; }
    public void setSaleStatus(String saleStatus) { this.saleStatus = saleStatus; }

    // Add a home
    public static String addHome(Home home) {
        try {
            inventory.add(home);
            return "Home added successfully. ID: " + home.getId();
        } catch (Exception e) {
            return "Failed to add home: " + e.getMessage();
        }
    }

    // Remove a home by ID
    public static String removeHome(int id) {
        try {
            for (Home home : inventory) {
                if (home.getId() == id) {
                    inventory.remove(home);
                    return "Home with ID " + id + " removed successfully.";
                }
            }
            return "No home found with ID " + id;
        } catch (Exception e) {
            return "Failed to remove home: " + e.getMessage();
        }
    }

    // Update sale status by ID
    public static String updateHome(int id, String newStatus) {
        try {
            for (Home home : inventory) {
                if (home.getId() == id) {
                    home.setSaleStatus(newStatus);
                    return "Home with ID " + id + " updated successfully.";
                }
            }
            return "No home found with ID " + id;
        } catch (Exception e) {
            return "Failed to update home: " + e.getMessage();
        }
    }

    // List all homes
    public static ArrayList<String[]> listHomes() {
        ArrayList<String[]> infoList = new ArrayList<>();
        try {
            for (Home home : inventory) {
                infoList.add(new String[] {
                        String.valueOf(home.getId()), // ID added
                        String.valueOf(home.getSquareFeet()),
                        home.getAddress(),
                        home.getCity(),
                        home.getState(),
                        String.valueOf(home.getZipCode()),
                        home.getModelName(),
                        home.getSaleStatus()
                });
            }
        } catch (Exception e) {
            System.out.println("Error listing homes: " + e.getMessage());
        }
        return infoList;
    }

    // Print to file
    public static String printToFile(String path) {
        try (FileWriter writer = new FileWriter(path)) {
            for (String[] info : listHomes()) {
                writer.write(String.join(", ", info) + "\n");
            }
            return "File written to " + path;
        } catch (IOException e) {
            return "Failed to write file: " + e.getMessage();
        }
    }
}
