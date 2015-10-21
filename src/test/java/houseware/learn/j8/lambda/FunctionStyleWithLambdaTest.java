package houseware.learn.j8.lambda;

import houseware.learn.j8.function.Person;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.function.Function;

/**
 * @author fphilip@houseware.es
 */
public class FunctionStyleWithLambdaTest {

    @BeforeClass
    public static void b() {

        System.out.println("=========================");
        System.out.println("== FunctiStyleTest ===");
        System.out.println("=========================");
    }

    @Test
    public void test_1() {


        List<Person> persons = Person.list();
        // Print Custom First Name and e-mail
        System.out.println("Custom");
        System.out.println("=======");
        for (Person person : persons) {
            System.out.println(
                    ((Function<Person, String>) p -> "Name: " + p.getGivenName() + " EMail: " + p.getEmail()).apply(person)
            );
        }
    }

    @Test
    public void test_2() {

        System.out.println("Functions");
        System.out.println("=========");

        List<Person> persons = Person.list();

        Function<Person, String> westernStyle = Person::westernName;


        Function<Person, String> easternStyle = Person::easternName;

        System.out.println("\n===Western Style===");

        persons.forEach(person -> {
            System.out.println(
                    person.printCustom(westernStyle)
            );
        });


        System.out.println("\n===Eastern Style===");
        persons.stream().filter(p-> p.getAge()>12).forEach(person -> {
            System.out.println(
                    person.printCustom(easternStyle)
            );
        });


    }
}
