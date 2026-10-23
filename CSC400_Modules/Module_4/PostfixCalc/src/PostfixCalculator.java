import java.io.FileNotFoundException;
import java.util.Stack;
import java.util.Scanner;
import java.io.File;

public class PostfixCalculator {
    public int evaluatePostfix(String postfixExpression) {
        Stack<Integer> myStack = new Stack<>();
        int value1;
        int value2;
        int result;
        String[] newTokens = postfixExpression.split(" ");
        for (String token: newTokens) {
            // Checks each token for integer or operator and does calculations //
            switch (token) {
                case "*":
                    if (myStack.size() >= 2) {
                        value1 = myStack.pop();
                        value2 = myStack.pop();
                        result = value2 * value1;
                        myStack.push(result);
                    }
                    else {
                        throw new IllegalArgumentException("Invalid postfix expression.");
                    }
                    break;
                case "/":
                    if (myStack.size() >= 2) {
                        value1 = myStack.pop();
                        value2 = myStack.pop();
                        result = value2 / value1;
                        myStack.push(result);
                    }
                    else {
                        throw new IllegalArgumentException("Invalid postfix expression.");
                    }
                    break;
                case "%":
                    if (myStack.size() >= 2) {
                        value1 = myStack.pop();
                        value2 = myStack.pop();
                        result = value2 % value1;
                        myStack.push(result);
                    }
                    else {
                        throw new IllegalArgumentException("Invalid postfix expression.");
                    }
                    break;
                case "+":
                    if (myStack.size() >= 2) {
                        value1 = myStack.pop();
                        value2 = myStack.pop();
                        result = value2 + value1;
                        myStack.push(result);
                    }
                    else {
                        throw new IllegalArgumentException("Invalid postfix expression.");
                    }
                    break;
                case "-":
                    if (myStack.size() >= 2) {
                        value1 = myStack.pop();
                        value2 = myStack.pop();
                        result = value2 - value1;
                        myStack.push(result);
                    }
                    else {
                        throw new IllegalArgumentException("Invalid postfix expression.");
                    }
                    break;
                default:
                    try {
                        int newToken = Integer.parseInt(token);
                        myStack.push(newToken);
                    }
                    catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Invalid postfix expression.");
                    }
            }
        }
        if (myStack.size() == 1) {
            return myStack.pop();
        }
        else {
            throw new IllegalArgumentException("Invalid postfix expression.");
        }
    }
    // Method to read each line from a file and evaluates //
    public void readFile() {
        int count = 0;
        try {
            File myFile = new File("expressions.txt");
            Scanner myScanner = new Scanner(myFile);
            while (myScanner.hasNextLine()) {
                count++;
                String expression = myScanner.nextLine();
                try {
                    System.out.println("File Result " + count + ": " + evaluatePostfix(expression));
                }
                catch (IllegalArgumentException e){
                    System.out.println (e.getMessage());
                }
            }
            myScanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File Not Found!");
        }
    }
    public static void main(String[] args) {
        PostfixCalculator calculator = new PostfixCalculator();

        // Example 1: Valid Expression //
        try {
            String expression1 = "4 2 * 3 +";
            System.out.println("Result 1: " + calculator.evaluatePostfix(expression1));
        }
        catch (IllegalArgumentException e) {
            System.out.println (e.getMessage());
        }

        // Example 2: Valid Expression //
        try {
            String expression2 = "5 3 + 7 *";
            System.out.println("Result 2: " + calculator.evaluatePostfix(expression2));
        }
        catch (IllegalArgumentException e) {
            System.out.println (e.getMessage());
        }

        // Example 3: Multidigit number in Expression //
        try {
            String expression3 = "42 3 * 7 +"; // Using multidigit number
            System.out.println("Result 3: " + calculator.evaluatePostfix(expression3));
        }
        catch (IllegalArgumentException e) {
            System.out.println (e.getMessage());
        }

        // Example 4: Invalid Expression //
        try {
            String expression4 = "4 2 * +"; // Missing operand
            System.out.println("Result 4: " + calculator.evaluatePostfix(expression4));
        }
        catch (IllegalArgumentException e) {
            System.out.println (e.getMessage());
        }

        // Calls readfile() to test expressions from file expressions.txt
        calculator.readFile();
    }
}


