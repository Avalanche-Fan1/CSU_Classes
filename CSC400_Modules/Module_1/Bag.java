public class Bag<T> {
    private T[] items;
    private int numberOfEntries;

    // Bag Constructor //
    public Bag() {
        numberOfEntries = 0;
        items = (T[]) new Object[100];
    }

    // Add Method Adds item to the Bag //
    public void add(T item) {
        if (numberOfEntries == items.length) {
            System.out.print("Your bag is full");
        }
        else{
            items[numberOfEntries] = item;
            numberOfEntries++;
        }

    }

    // Removes one occurrence of the specified item from the Bag //
    public void remove(T item) {

        for (int i = 0; i < numberOfEntries; i++) {
            if (items[i].equals(item)) {
                items[i] = items[numberOfEntries -1];
                items[numberOfEntries -1] = null;
                numberOfEntries--;
                return;
            }
        }
    }

    // Contains Method for checking if the Bag contains item //
    public boolean contains(T item) {

        for (int i = 0; i < numberOfEntries; i++) {
            if (items[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    // Count Method returns the number of occurrences of the specified item in the Bag //
    public int count(T item) {

        int count = 0;

        for (int i = 0; i < numberOfEntries; i++) {
            if (items[i].equals(item)) {
                count++;
            }
        }
        return count;
    }

    // Display Method displays the contents of the Bag //
    public void display() {

        for (int i = 0; i < numberOfEntries; i++) {
            System.out.println(items[i]);
        }

    }
}


