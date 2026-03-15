import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        // Declare Variables and Arrays //
        double yearlyAvg;
        int i;
        String userInput;
        double[] avgMonthlyTemp = {
                28.3, 31.7, 54.6, 63.9,
                71.8, 82.9, 89.4, 92.5,
                84.8, 72.7, 56.0, 40.6
        };
        String[] monthName = {
                "January","February","March",
                "April","May","June","July",
                "August","September","October",
                "November","December"
        };
        // Create while loop to allow repeat uses until user exits
        while (true) {
           System.out.print("\nEnter Month [1-12] or 'year' to see Average Temperature ('exit to leave): ");
            userInput = scnr.nextLine();
            if (userInput.equalsIgnoreCase("exit")) {  // Loop exit //
                break;
            }
            if (userInput.equalsIgnoreCase("year")) {  // Process Month and Yearly//
                double yearlyTotal = 0;
               for (i = 0; i <avgMonthlyTemp.length; ++i)  {   // Iterate for months and to calculate year total //
                  System.out.println("The Average Temperature for " + monthName[i]
                          + " was " + avgMonthlyTemp[i] + " degrees Fahrenheit");
                  yearlyTotal = yearlyTotal + avgMonthlyTemp[i];
               }
              yearlyAvg = yearlyTotal / avgMonthlyTemp.length;
              System.out.printf("The yearly Average Temperature was %.1f degrees Fahrenheit", yearlyAvg);
            }
            else if (userInput.matches("\\d+")) {  // make sure input is a valid digit //

                int month = Integer.parseInt(userInput);  // converts STRIMG to INT //

                if (month >= 1 && month <= 12) {  // Displays month chosen //
                    System.out.println("The Average Temperature for "
                            + monthName[month - 1] + " was "
                            + avgMonthlyTemp[month - 1]
                            + " degrees Fahrenheit");
                } else {
                    System.out.println("Please enter a number between 1 and 12.");  // asks for valid input //
                }
            }
            else   {
                System.out.println("Invalid input.");  // Give message for invalid input //
            }
        }
    }
}