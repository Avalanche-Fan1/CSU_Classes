import java.util.Scanner;

public class HomeInventory {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        String choice = "";

        try {
            while (!choice.equals("6")) {

                printMenu();
                choice = scnr.nextLine();

                switch (choice) {

                    case "1":

                        int squareFeet = getIntInputInRange(
                                scnr,
                                "Enter square feet:",
                                1,
                                Integer.MAX_VALUE,
                                "Square feet must be at least 1."
                        );

                        System.out.println("Enter address:");
                        String address = scnr.nextLine();

                        System.out.println("Enter city:");
                        String city = scnr.nextLine();

                        System.out.println("Enter state:");
                        String state = scnr.nextLine();

                        int zip = getIntInputInRange(
                                scnr,
                                "Enter zip code:",
                                0,
                                99999,
                                "Zip code must be between 00000 and 99999."
                        );

                        System.out.println("Enter model name:");
                        String model = scnr.nextLine();

                        String status = getSaleStatus(scnr);

                        System.out.println(Home.addHome(squareFeet, address, city, state, zip, model, status));
                        break;

                    case "2":

                        String removeListMessage = Home.listHomes();
                        if (!Home.hasHomes()) {
                            System.out.println(removeListMessage);
                            break;
                        }

                        int removeIndex = getIntInputInRange(
                                scnr,
                                "Enter home number to remove:",
                                1,
                                Home.getHomeCount(),
                                "Home number must match a listed home."
                        ) - 1;

                        System.out.println(Home.removeHome(removeIndex));
                        break;

                    case "3":

                        String updateListMessage = Home.listHomes();
                        if (!Home.hasHomes()) {
                            System.out.println(updateListMessage);
                            break;
                        }

                        int updateIndex = getIntInputInRange(
                                scnr,
                                "Enter home number to update:",
                                1,
                                Home.getHomeCount(),
                                "Home number must match a listed home."
                        ) - 1;

                        String newStatus = getSaleStatus(scnr);

                        System.out.println(Home.updateHomeStatus(updateIndex, newStatus));
                        break;

                    case "4":
                        System.out.println(Home.listHomes());
                        break;

                    case "5":

                        System.out.println("Print file? (Y/N)");
                        String response = scnr.nextLine();

                        if (response.equalsIgnoreCase("Y")) {
                            System.out.println(Home.printHomesToFile());
                        }
                        else {
                            System.out.println("File not printed.");
                        }
                        break;

                    case "6":
                        System.out.println("Exiting program.");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } catch (Exception e) {
            System.out.println("Main error: " + e.getMessage());
        }

        scnr.close();
    }

    private static int getIntInputInRange(
            Scanner scnr, String prompt, int min, int max, String rangeMessage) {

        try {
            // Keep prompting until user enters an integer inside the required range.
            while (true) {

                System.out.println(prompt);
                String input = scnr.nextLine();

                try {
                    int value = Integer.parseInt(input);

                    if (value < min || value > max) {
                        System.out.println(rangeMessage);
                        continue;
                    }

                    return value;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number. Please enter a whole number.");
                }
            }
        } catch (Exception e) {
            System.out.println("Input error: " + e.getMessage());
            return min;
        }
    }

    private static String getSaleStatus(Scanner scnr) {
        try {
            String saleStatus;

            while (true) {

                System.out.println("Enter sale status (sold, available, under contract):");
                saleStatus = scnr.nextLine().toLowerCase();

                if (saleStatus.equals("sold") ||
                        saleStatus.equals("available") ||
                        saleStatus.equals("under contract")) {

                    return saleStatus;
                }

                System.out.println("Invalid status. Please enter sold, available, or under contract.");
            }
        } catch (Exception e) {
            System.out.println("Status input error: " + e.getMessage());
            return "available";
        }
    }

    public static void printMenu() {
        try {
            System.out.println("\nHome Inventory Menu");
            System.out.println("1. Add Home");
            System.out.println("2. Remove Home");
            System.out.println("3. Update Home Status");
            System.out.println("4. List Homes");
            System.out.println("5. Print Homes to File");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
        } catch (Exception e) {
            System.out.println("Failed to print menu: " + e.getMessage());
        }
    }
}
