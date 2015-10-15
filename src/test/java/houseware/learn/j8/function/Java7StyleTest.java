package houseware.learn.j8.function;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

/**
 * @author fphilip@houseware.es
 */
public class Java7StyleTest {

    @BeforeClass
    public static void b() {

        System.out.println("=========================");
        System.out.println("== Java7StyleTest ===");
        System.out.println("=========================");
    }

    @Test
    public void test_1() {


        List<Person> list1 = Person.list();

        // Print Names Western
        System.out.println("\n===Print Western Names===");
        for (Person person : list1) {
            person.printWesternName();
        }

        // Print Names Eastern
        System.out.println("\n===Print Eastern Names===");
        for (Person person : list1) {
            person.printEasternName();
        }

    }

}
