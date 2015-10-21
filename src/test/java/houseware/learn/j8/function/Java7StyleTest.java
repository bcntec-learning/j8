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



        // Print Names Western
        System.out.println("===Print Western Names===");
        for (Person person :  Person.list()) {
            person.printWesternName();
        }
    }

    @Test
    public void test_2() {
        // Print Names Eastern
        System.out.println("===Print Eastern Names===");
        for (Person person :  Person.list()) {
            person.printEasternName();
        }

    }

}
