public class Main {
    // Main test method //
    public static void main(String[] args) {

        // Creates an array with 11 numbers //
        Integer[] numberArray = new Integer[]{783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94};
        // Creates a RadixSort object //
        RadixSort myRadixSort = new RadixSort();

        // Prints all items in the original array in the original order //
        System.out.println("Original Array:");
        for (int x = 0; x < numberArray.length; x++) {
            System.out.print(numberArray[x] + " ");
        }

        // Calls the radixSort method to sort the numberArray //
        Integer[] sortedArray = myRadixSort.radixSort(numberArray);

        // Prints out the sortedArray //
        System.out.println();
        System.out.println("Sorted Array:");
        for (int x = 0; x < sortedArray.length; x++) {
            System.out.print(sortedArray[x] + " ");
        }
    }
}
