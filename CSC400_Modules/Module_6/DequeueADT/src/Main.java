import java.util.Iterator;
import java.util.Random;

public class Main {
    // Main test method //
    public static void main(String[] args) {

        Random random = new Random();

        // Array of ten random integers
        int[] randomNumbers = new int[10];
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = random.nextInt(1000)+1;
        }
        CustomDeque customDeque = new CustomDeque();

        // Verify if deque is empty //
        System.out.println("\nIs the deque empty? " + customDeque.isEmpty());

        // Add 5 numbers to the front //
        for (int i = 0; i <5; i++) {
            customDeque.enqueueFront(randomNumbers[i]);
        }

        // Add 5 numbers to the rear //
        for (int i = 5; i <randomNumbers.length; i++) {
            customDeque.enqueueRear(randomNumbers[i]);
        }

        // Iterate and display elements
        Iterator<Integer> iterator = customDeque.iterator();

        System.out.print("Deque after adding numbers: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        // Remove number from front of deque //
        int removedFront = customDeque.dequeueFront();
        System.out.println("\nRemoved from front: " + removedFront);

        // Remove number from the rear of deque //
        int removedRear = customDeque.dequeueRear();
        System.out.println("Removed from rear: " + removedRear);

        // // Reset iterator to traverse the deque again //
        iterator = customDeque.iterator();

        // Display new deque //
        System.out.print("Deque after removing front and rear: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        // Verify if deque is empty //
        System.out.println("\nIs the deque empty? " + customDeque.isEmpty());
    }
}
