/*
 * Class Name: RollnoComparator
 *
 * Description:
 * This class implements the Comparator interface to compare two Student objects
 * based on their roll numbers. It uses Integer comparison to determine the order
 * of students numerically.
 *
 * Purpose:
 * Allows sorting of Student objects in ascending order by roll number when used
 * with the SelectionSort class.
 */
import java.util.Comparator;
public class RollnoComparator implements Comparator<Student> {

    // Compare method //
    @Override
    public int compare(Student s1, Student s2){

        return Integer.compare(s1.getRollno(), s2.getRollno());
    }
}
