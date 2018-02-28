package houseware.learn.j8.lambda;

/**
* @author fphilip@houseware.es
*/
public class Person {
    public String firstName;
    public String lastName;
    public int age;

    public Person() {}

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName, int age) {
        this(firstName, lastName);
        this.age=age;

    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}