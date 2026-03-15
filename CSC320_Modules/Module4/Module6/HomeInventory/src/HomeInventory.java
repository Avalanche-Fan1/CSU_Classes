import java.util.Scanner;

public class HomeInventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean done = false;

        try {
            while (!done) {
                System.out.println("\nHome Inventory Menu:");
                System.out.println("1. Add a new home");
                System.out.println("2. List all homes");
                System.out.println("3. Remove a home by ID");
                System.out.println("4. Update sale status by ID");
                System.out.println("5. Print inventory to file");
                System.out.println("6. Exit");
                System.out.print("Enter choice: ");

                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        System.out.print("Enter square feet: ");
                        int sqft = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter address: ");
                        String address = scanner.nextLine();
                        System.out.print("Enter city: ");
                        String city = scanner.nextLine();
                        System.out.print("Enter state: ");
                        String state = scanner.nextLine();
                        System.out.print("Enter zip code: ");
                        int zip = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter model name: ");
                        String model = scanner.nextLine();
                        System.out.print("Enter sale status (available/sold/under contract): ");
                        String status = scanner.nextLine();

                        Home home = new Home(sqft, address, city, state, zip, model, status);
                        System.out.println(Home.addHome(home));
                        break;

                    case "2":
                        System.out.println("ID, SqFt, Address, City, State, Zip, Model, Status");
                        for (String[] info : Home.listHomes()) {
                            System.out.println(String.join(", ", info));
                        }
                        break;

                    case "3":
                        System.out.print("Enter ID of home to remove: ");
                        int removeId = Integer.parseInt(scanner.nextLine());
                        System.out.println(Home.removeHome(removeId));
                        break;

                    case "4":
                        System.out.print("Enter ID of home to update: ");
                        int updateId = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter new sale status: ");
                        String newStatus = scanner.nextLine();
                        System.out.println(Home.updateHome(updateId, newStatus));
                        break;

                    case "5":
                        System.out.print("Enter file path to save (e.g., C:\\Temp\\Home.txt): ");
                        String path = scanner.nextLine();
                        System.out.println(Home.printToFile(path));
                        break;

                    case "6":
                        done = true;
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Exiting program.");
        }
    }
}
