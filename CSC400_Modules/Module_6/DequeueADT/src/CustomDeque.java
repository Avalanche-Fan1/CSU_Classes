import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class CustomDeque {
    private Deque<Integer> deque;

    public CustomDeque() {
        this.deque = new LinkedList<>();
    }

    // Method to add to front //
    public void enqueueFront(int data) {
        deque.addFirst(data);
    }

    // Method to add to rear //
    public void enqueueRear(int data) {
        deque.addLast(data);
    }

    // Method to remove from front //
    public int dequeueFront() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return deque.removeFirst();
    }

    // Method to remove from rear //
    public int dequeueRear() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return deque.removeLast();
    }

    // Return a new iterator for the deque //
    public Iterator<Integer> iterator() {
        return new DequeIterator();
    }

    // Check if the deque is empty //
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    // Inner class used to iterate through the deque //
    private class DequeIterator implements Iterator<Integer> {

        // Create an iterator for the underlying deque
        private Iterator<Integer> iterator = deque.iterator();

        // Check if another element exists in the deque
        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        // Return the next element in the deque
        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return iterator.next();
        }
    }
}
