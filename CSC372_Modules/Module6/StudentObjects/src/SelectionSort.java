/*
 * Class Name: SelectionSort
 *
 * Description:
 * This class contains a static method that performs a selection sort on an
 * ArrayList of Student objects. The sorting is done using a Comparator, which
 * allows the list to be sorted based on different criteria such as name or
 * roll number.
 *
 * Purpose:
 * Provides a custom implementation of the selection sort algorithm without
 * using Java's built-in sorting methods, as required by the assignment.
 */
import java.util.ArrayList;
import java.util.Comparator;

public class SelectionSort {
    public static void selectionSort(ArrayList<Student> list, Comparator<Student> comp) {
        for (int i = 0; i < list.size(); i++) {
           int minIndex = i;
            for (int j = i +1; j < list.size(); j++) {
                if (comp.compare(list.get(j), list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != 1) {
                Student temp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, temp);
            }   
        }
    }
}
