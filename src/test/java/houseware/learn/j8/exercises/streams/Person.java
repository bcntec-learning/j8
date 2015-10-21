package houseware.learn.j8.exercises.streams;

/**
 * @author fphilip@houseware.es
 */
public class Person {

    public Person(final String nameValue, final int ageValue) {
        name = nameValue;
        age = ageValue;
    }

    public Person(final String nameValue, final int ageValue, final String nationalityValue) {
        name = nameValue;
        age = ageValue;
        nationality = nationalityValue;
    }


    private String name;

    public String getName() {
        return name;
    }

    private int age;

    public int getAge() {
        return age;
    }

    private String nationality;

    public String getNationality() {
        return nationality;
    }

}