/*
 * Class Name: Student
 *
 * Description:
 * This class represents a Student object. Each student contains a roll number,
 * name, and address. The class provides a constructor to initialize these values,
 * getter methods to access them, and a toString() method to display the student's
 * information in a readable format.
 *
 * Purpose:
 * Used to create individual student objects that will be stored in an ArrayList
 * and sorted using different comparator classes.
 */
public class Student {

    private int rollno;
    private String name;
    private String address;

    // Constructor //
    public Student (int rollno, String name, String address) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    //Getters for Students //
    public int getRollno(){
        return rollno;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    // toString to set printing format //
    @Override
    public String toString() {
        return
            "ID: " + rollno +
            "\nName: " + name +
            "\nAddress: " + address;
    }
}
