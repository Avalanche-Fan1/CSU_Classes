import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Declare all variables //
        int numCounter = 0;
        int inputMax;
        double userNum;
        double numTotal = 0.0;
        double numAverage;
        double numMax = 0.0;
        double numMin = 0.0;
        double numInterest;

        Scanner scnr = new Scanner(System.in);

        // Ask user how many numbers they will enter //
        System.out.print("How many numbers would you like to enter? ");
        inputMax = scnr.nextInt();

        // Guard against invalid input
        if (inputMax <= 0) {
            System.out.println("You must enter at least one number.");
            return;
        }

        // --- Loop Peeling: handle first iteration separately ---
        System.out.print("Please enter number 1: ");
        userNum = scnr.nextDouble();

        numTotal = userNum;
        numMax = userNum;
        numMin = userNum;
        numCounter = 1;

        // --- Main loop for remaining inputs ---
        while (numCounter < inputMax) {
            System.out.print("Please enter number " + (numCounter + 1) + ": ");
            userNum = scnr.nextDouble();

            numTotal = numTotal + userNum;

            if (userNum > numMax) {
                numMax = userNum;
            }

            if (userNum < numMin) {
                numMin = userNum;
            }

            numCounter = numCounter + 1;
        }

        // Calculate results
        numAverage = numTotal / inputMax;
        numInterest = numTotal * 0.20;

        // Output results
        System.out.printf("The Total of your numbers is %.2f\n", numTotal);
        System.out.printf("The Average of your numbers is %.2f\n", numAverage);
        System.out.println("The Maximum of your numbers is " + numMax);
        System.out.println("The Minimum of your numbers is " + numMin);
        System.out.printf("The Interest on your numbers (at 20%%) is %.2f\n", numInterest);
    }
}

