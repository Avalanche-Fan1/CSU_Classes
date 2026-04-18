// Main Class //
/*
 * Class Name: Main
 *
 * Description:
 * This class contains the main method, which serves as the entry point of the
 * program. It creates an ArrayList of Student objects, displays the original list,
 * and then sorts and displays the list using different comparators (by name and
 * by roll number).
 *
 * Purpose:
 * Demonstrates the functionality of the Student, Comparator, and SelectionSort
 * classes working together to store, sort, and display student data.
 */
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<Student>();

        // Add entries into ArrayList //
        studentList.add(new Student(58214, "John Lennon", "9879 E Sergeant St"));
        studentList.add(new Student(90376, "Paul McCartney", "9878 W Peppers Ave"));
        studentList.add(new Student(76835, "Ringo Starr", "9877 Lonely Hearts Cir"));
        studentList.add(new Student(42901, "George Harrison", "9876 Club Blvd"));
        studentList.add(new Student(61587, "Peter Quill", "8484 StarLord St"));
        studentList.add(new Student(23894, "Drax Jones", "8479 Destroyer Ave"));
        studentList.add(new Student(79012, "Cillian Murphy", "5412 Peaky Blvd"));
        studentList.add(new Student(35468, "Bruce Willis", "7293 Die Hard Cir"));
        studentList.add(new Student(86723, "Tyler Joseph", "4400 Blurryface St"));
        studentList.add(new Student(14729, "Josh Dunn", "111 Drummer Ave"));

        // Make copies of the list so each sort starts from the original order //
        ArrayList<Student> nameList = new ArrayList<>(studentList);
        ArrayList<Student> rollnoList = new ArrayList<>(studentList);

        // Display original list //
        System.out.println("==== Original List ====");
        for (Student student : studentList) {
            System.out.println(student);
            System.out.println();
        }

        // Sort and display by name //
        System.out.println("==== Sorted List (by Name) ====");
        SelectionSort.selectionSort(nameList, new NameComparator());
        for (Student student : nameList) {
            System.out.println(student);
            System.out.println();
        }

        // Sort and display by rollno //
        System.out.println("==== Sorted List (by Rollno) ====");
        SelectionSort.selectionSort(rollnoList, new RollnoComparator());
        for (Student student : rollnoList) {
            System.out.println(student);
            System.out.println();
        }
    }

}
