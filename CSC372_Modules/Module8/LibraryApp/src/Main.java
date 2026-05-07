import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        String choice = "";
        Inventory myInventory = new Inventory();

        try {
            while (!choice.equals("6")) {


                printMenu();
                choice = scnr.nextLine();


                switch (choice) {


                    case "1":

                        System.out.print("Enter Book ID: ");
                        int id = scnr.nextInt();
                        scnr.nextLine();

                        System.out.print("Enter Book Title: ");
                        String title = scnr.nextLine();

                        System.out.print("Enter Book Author: ");
                        String author = scnr.nextLine();

                        System.out.print("Enter Book ISBN: ");
                        String isbn = scnr.nextLine();

                        System.out.print("Enter Book Pages: ");
                        int pages = scnr.nextInt();
                        scnr.nextLine();

                        myInventory.addBook(id,title,author,isbn,pages);

                        break;


                    case "2":

                        System.out.print("Enter Book ID to borrow: ");
                        int borrowID = scnr.nextInt();
                        scnr.nextLine();

                        myInventory.borrowBook(borrowID);
                        break;


                    case "3":
                        System.out.print("Enter Book ID to return: ");
                        int returnID = scnr.nextInt();
                        scnr.nextLine();

                        myInventory.returnBook(returnID);
                        break;

                    case "4":
                        System.out.print("Enter title to search for: ");
                        String searchTitle = scnr.nextLine();

                        myInventory.searchByTitle(searchTitle);
                        break;

                    case "5":

                        myInventory.printAll();
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

    public static void printMenu() {
        try {
            System.out.println("\nHome Library Menu");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Search by Title");
            System.out.println("5. Print All Books");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
        } catch (Exception e) {
            System.out.println("Failed to print menu: " + e.getMessage());
        }
    }

}
