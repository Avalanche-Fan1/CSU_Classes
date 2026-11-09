import java.util.ArrayList;
import java.util.NoSuchElementException;

public class PersonQueue {

    private ArrayList<Person> personList = new ArrayList<>();

    // Enqueue Method //
    public void enqueue(Person person) {
        personList.add(person); // Add person to personList //
    }

    // Dequeue Method //
    public Person dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is Empty");
        }
        return personList.remove(0); // Return Person element from personList //
    }

    // Checks for Empty ArrayList //
    public boolean isEmpty() {
        return personList.isEmpty();
    }
    // Display Queue Method //
    public void displayQueue() {
        for (int i = 0; i < personList.size(); i++) {
            System.out.println(personList.get(i));
        }
    }
    // Sort by Last Name //
    public void sortByLastName() {
        ArrayList<Person> sortByNameList = new ArrayList<>(personList);
        quickSortByLastName(sortByNameList, 0, sortByNameList.size() -1);
        for (int i = 0; i < sortByNameList.size(); i++) {
            System.out.println(sortByNameList.get(i));

        }
    }
    // Quick Sort for Sorting by Last Name //
    private void quickSortByLastName(ArrayList<Person> list , int low, int high) {
        if (low < high) {
            int pivotIndex = partitionByLastName(list, low, high);
            quickSortByLastName(list, low, pivotIndex -1);
            quickSortByLastName(list,pivotIndex + 1, high);
        }
    }
    // Patrition Method for Last Name Quick Sort //
    private int partitionByLastName(ArrayList<Person> list, int low, int high) {
        Person pivot = list.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (list.get(j).getLastName().compareToIgnoreCase(pivot.getLastName()) > 0) {
                i++;
                Person temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j,temp);
            }
        }
        Person temp = list.get(i+1);
        list.set(i + 1, pivot);
        list.set(high,temp);
        return i + 1;
    }

    // Sort by age //
    public void sortByAge() {
        ArrayList<Person> sortByAge = new ArrayList<>(personList);
        quickSortByAge(sortByAge, 0, sortByAge.size() -1);
        for (int i = 0; i < sortByAge.size(); i++) {
            System.out.println(sortByAge.get(i));
        }
    }

    // Quick Sort by Age //
    private void quickSortByAge(ArrayList<Person> list , int low, int high) {
        if (low < high) {
            int pivotIndex = partitionByAge(list, low, high);
            quickSortByAge(list, low, pivotIndex -1);
            quickSortByAge(list,pivotIndex + 1, high);
        }
    }

    // Partition for Quick Sort by Age //
    private int partitionByAge(ArrayList<Person> list, int low, int high) {
        Person pivot = list.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (list.get(j).getPersonAge() > pivot.getPersonAge()) {
                i++;
                Person temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j,temp);
            }
        }
        Person temp = list.get(i+1);
        list.set(i + 1, pivot);
        list.set(high,temp);
        return i + 1;
    }
}

