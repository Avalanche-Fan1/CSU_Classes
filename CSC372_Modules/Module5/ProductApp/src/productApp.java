import java.util.Scanner;

public class productApp {

     public static void userInput (int[] userNums, int i, Scanner scnr) {

        // Base Case //
        if (i >= userNums.length) {
            return;
        }
        // Recursive Case //
        System.out.print(" Enter number " + (i + 1) + ": ");
        userNums[i] = scnr.nextInt();

        userInput(userNums, i + 1, scnr);
    }

    public static void main(String[]args) {

        int numProduct = 1;
        Scanner scnr = new Scanner(System.in);
        int[] userNums = new int[5];

        // 1st call to userInput //
        userInput(userNums, 0, scnr);

        // Calculate Product of numbers (fits any size array) //
        for (int i = 0; i < userNums.length; i++) {
            numProduct *= userNums[i];
        }
        // print results to user //
        System.out.println("The product of your numbers is: " + numProduct);
    }
}
