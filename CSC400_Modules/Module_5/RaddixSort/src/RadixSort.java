import java.util.LinkedList;
import java.util.Queue;

public class RadixSort {
    public Integer[] radixSort(Integer[] numbersArray) {
        // Creates an array of queues (buckets)//
        Queue<Integer>[] queueArray = new Queue[10];
        int divisor = 1;
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < queueArray.length; y++) {
                queueArray[y] = new LinkedList<>();
            }
            // Sorts items into queues using the ones, tens, and then hundreds digits //
            for (int y = 0; y < numbersArray.length; y++) {
                int bucketIndex = (numbersArray[y] / divisor) % 10;
                queueArray[bucketIndex].offer(numbersArray[y]);
            }
            // Sets and Resets the array index before pulling numbers from the queues //
            int arrayIndex = 0;

            // Pulls each number out of each queue and places it back into the array //
            for (int y = 0; y < queueArray.length; y++) {
                while (!queueArray[y].isEmpty()) {
                    numbersArray[arrayIndex] = queueArray[y].poll();
                    arrayIndex++;
                }
            }
            // Changes the divisor for the ones, tens, and hundreds digits //
            divisor = divisor * 10;
        }
        // Returns sorted array //
        return numbersArray;
    }
}

