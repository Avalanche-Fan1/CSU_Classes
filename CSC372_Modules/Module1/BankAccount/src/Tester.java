import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        String choice;

        do {
            // Loop Tester for multiple tests //
            CheckingAccount account = new CheckingAccount();

            System.out.print("Enter first name: ");
            String firstName = scnr.nextLine();

            System.out.print("Enter last name: ");
            String lastName = scnr.nextLine();

            System.out.print("Enter account ID: ");
            int accountID = scnr.nextInt();

            System.out.print("Enter interest rate: ");
            double interestRate = scnr.nextDouble();

            System.out.print("Enter deposit amount: ");
            double deposit = scnr.nextDouble();

            System.out.print("Enter withdrawal amount: ");
            double withdrawal = scnr.nextDouble();
            System.out.println();
            scnr.nextLine(); // clears leftover newline

            // Set account information
            account.setFirstName(firstName);
            account.setLastName(lastName);
            account.setAccountID(accountID);
            account.setInterestRate(interestRate);

            // Process transactions
            account.deposit(deposit);
            account.withdrawl(withdrawal);

            System.out.println();
            account.displayAccount();

            // Ask user if they want to run again
            System.out.print("\nRun program again? (yes/no): ");
            choice = scnr.nextLine();

        } while (choice.equalsIgnoreCase("yes"));

        System.out.println("Program ended.");

    }
}