package houseware.learn.j8.exercises.streams;

import org.junit.Test;

import java.util.List;

import static houseware.learn.j8.exercises.streams.OldestPerson.getOldestPerson7;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author fphilip@houseware.es
 */
public class OldestPersonTest {

    @Test
    public void getOldestPersonShouldReturnOldestPerson() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = asList(sara, eva, viktor);
        assertThat(getOldestPerson7(collection)).isEqualToComparingFieldByField(eva);
    }

    @Test
    public void compare() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = asList(sara, eva, viktor);
//        assertThat(getOldestPerson7(collection)).hasSameElementsAs(getOldestPerson8(collection));
    }

}
