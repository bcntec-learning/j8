package houseware.learn.j8.stream.exercises;

import org.junit.Test;

import java.util.List;

import static houseware.learn.j8.stream.exercises.OldestPerson.getOldestPerson7;
import static houseware.learn.j8.stream.exercises.OldestPerson.getOldestPerson8;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author fphilip@houseware.es
 */
public class OldestPersonTest {

    @Test
    public void getOldestPersonShouldReturnOldestPerson() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Francisco", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = asList(sara, eva, viktor);
        assertThat(getOldestPerson7(collection)).isEqualToComparingFieldByField(eva);
    }

    @Test
    public void compare() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Francisco", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = asList(sara, eva, viktor);
        assertThat(getOldestPerson7(collection)).isEqualToComparingFieldByField(getOldestPerson8(collection));
    }

}
