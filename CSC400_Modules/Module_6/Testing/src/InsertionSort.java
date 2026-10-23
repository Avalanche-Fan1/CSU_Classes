public class InsertionSort {
    public static void main(String[] args) {

        int[] numbers = {42, 15, 8, 23, 4, 16};

        System.out.println("Original Array:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }

        for (int x = 1; x < numbers.length; x++) {
            int current = numbers[x];
            int y = x - 1;

            while (y >= 0 && numbers[y] > current) {
                numbers[y + 1] = numbers[y];
                y--;
            }

            numbers[y + 1] = current;
        }

        System.out.println();
        System.out.println("Sorted Array:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
