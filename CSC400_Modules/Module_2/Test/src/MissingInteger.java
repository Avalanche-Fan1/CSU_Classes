public class MissingInteger {

    public static int findMissing(int[] numbers) {
        int n = numbers.length;

        // Sum of all integers from 1 through n + 1
        int expectedSum = (n + 1) * (n + 2) / 2;

        // Subtract each integer that appears in the array
        for (int index = 0; index < n; index++) {
            expectedSum = expectedSum - numbers[index];
        }

        // The remaining value is the missing integer
        return expectedSum;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 6, 5, 1, 4};

        int missing = findMissing(numbers);

        System.out.println("The missing integer is: " + missing);
    }
}