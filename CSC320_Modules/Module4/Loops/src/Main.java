//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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

      // Start while loop to get each user input and calculate Total //
      while (numCounter < (inputMax))  {
          // user inputs number //
          System.out.print("Please enter number" + (numCounter +1) + ": ");
          userNum = scnr.nextDouble();
          // Keep total SUM of numbers entered //
          numTotal = numTotal + userNum;
          // Determine if the number is the MAX # //
          if (userNum > numMax)  {
              numMax = userNum;
          }
          // Skip the 1st iteration where Min == 0.0 //
          if (numCounter == 0) {
              numMin = userNum;
          }
          else  {
              // Determine if the number is the MIN //
              if (userNum < numMin)  {
                  numMin = userNum;
              }
          }
          // Prevent infinite loop by increasing counter //
          numCounter = numCounter + 1;
      }
      // Calculate Average //
      numAverage = numTotal / inputMax;
      // Calculate Interest //
      numInterest = numTotal * .20;

      // Print Total, Average, Max, Min and 20% Intereste //
      System.out.println("The Total of your numbers is " + numTotal);
      System.out.println("The Average of your numbers is " + numAverage);
      System.out.println("The Maximum of your numbers is " + numMax);
      System.out.println("The Minimum of your numbers is " + numMin);
      System.out.println("The Interest on your numbers (at 20%) is " + numInterest);
    }
}