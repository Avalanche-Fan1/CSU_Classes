import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PersonQueue myQueue = new PersonQueue();

        Scanner scanner = new Scanner(System.in);

        // Loop to ask user for 5 entries //
        for (int i = 0; i < 5; i++) {

            System.out.print("Enter First Name: ");
            String firstName = scanner.nextLine();

            System.out.print("Enter Last Name: ");
            String lastName = scanner.nextLine();

            // Check Age for invalid inputs that are non-Integer //
            int age;
            while (true) {
                System.out.print("Enter Person's Age: ");
                String personAge = scanner.nextLine();
                try {
                    age = Integer.parseInt(personAge);
                    if (age < 0) {
                        System.out.println("Age cannot be negative. Please try again.");
                        continue;
                    }
                    break;
                }
                catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a whole number.");
                }

            }
            Person newPerson = new Person(firstName, lastName, age);

            myQueue.enqueue(newPerson);
        }

        // Display Original Queue //
        System.out.println("Original Queue");
        System.out.println();
        myQueue.displayQueue();

        // Display Queue Sorted by Last Name //
        System.out.println();
        System.out.println("Sorted by Last Name (Descending)");
        System.out.println();
        myQueue.sortByLastName();

        // Display Queue Sorted by Age //
        System.out.println();
        System.out.println("Sorted by Age (Descending)");
        System.out.println();
        myQueue.sortByAge();

    }
}
