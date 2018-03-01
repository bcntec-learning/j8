package houseware.learn.j8.stream.exercises;

import org.junit.Test;

import java.util.List;

import static houseware.learn.j8.stream.exercises.Kids.getKidNames7;
import static houseware.learn.j8.stream.exercises.Kids.getKidNames8;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author fphilip@houseware.es
 */
public class KidsTest {

    @Test
    public void getKidNameShouldReturnNamesOfAllKidsFromNorway() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Francisco", 40);
        Person eva = new Person("Eva", 42);
        Person anna = new Person("Anna", 5);
        List<Person> collection = asList(sara, eva, viktor, anna);
        assertThat(getKidNames7(collection))
                .contains("Sara", "Anna")
                .doesNotContain("Francisco", "Eva");
    }


    @Test
    public void compare() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Francisco", 40);
        Person eva = new Person("Eva", 42);
        Person anna = new Person("Anna", 5);
        List<Person> collection = asList(sara, eva, viktor, anna);
        assertThat(getKidNames7(collection)).hasSameElementsAs(getKidNames8(collection));

    }

}
