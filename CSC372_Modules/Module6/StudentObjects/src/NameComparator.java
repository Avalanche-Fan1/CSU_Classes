/*
 * Class Name: NameComparator
 *
 * Description:
 * This class implements the Comparator interface to compare two Student objects
 * based on their names. It uses the String compareTo() method to determine the
 * alphabetical order of student names.
 *
 * Purpose:
 * Allows sorting of Student objects in alphabetical order by name when used
 * with the SelectionSort class.
 */
import java.util.Comparator;
public class NameComparator implements Comparator<Student> {

    // Compare method //
    @Override
    public int compare(Student s1, Student s2){

       return s1.getName().compareTo(s2.getName());
    }
}
