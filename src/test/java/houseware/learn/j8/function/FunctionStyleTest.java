package houseware.learn.j8.function;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author fphilip@houseware.es
 */
public class FunctionStyleTest {

    @BeforeClass
    public static void b() {

        System.out.println("=========================");
        System.out.println("== FunctionStyleTest ===");
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
                    new Function<Person, String>() {
                        @Override
                        public String apply(Person p) {
                            return "Name: " + p.getGivenName() + " EMail: " + p.getEmail();

                        }
                    }.apply(person)
            );
        }
    }

    @Test
    public void test_2() {

        System.out.println("Functions");
        System.out.println("=========");

        List<Person> persons = Person.list();

        Function<Person, String> westernStyle =
                new Function<Person, String>() {
                    @Override
                    public String apply(Person p) {
                        return p.westernName();

                    }

                };


        Function<Person, String> easternStyle =
                new Function<Person, String>() {
                    @Override
                    public String apply(Person p) {
                        return p.easternName();
                    }

                };

        System.out.println("\n===Western Style===");
        persons.forEach(new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println(
                        person.printCustom(westernStyle)
                );

            }
        });


        System.out.println("\n===Eastern Style===");
        persons.forEach(new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println(
                        person.printCustom(easternStyle)
                );

            }
        });


    }
}
