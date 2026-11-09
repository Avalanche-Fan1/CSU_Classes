public class Person {
    private String firstName;
    private String lastName;
    private int personAge;

    // Constructor //
    public Person(String firstName, String lastName, int personAge) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personAge = personAge;
    }

    // Get First Name //
    public String getFirstName() {
        return firstName;
    }

    // Get Last Name //
    public String getLastName() {
        return lastName;
    }

    // Get First Age //
    public int getPersonAge() {
        return personAge;
    }

    /* Overrides the default toString() method to return the person's first name,
    last name, and age in a readable format. */
    @Override
    public String toString() {
        return firstName + " " + lastName + " " + personAge;
    }
}
