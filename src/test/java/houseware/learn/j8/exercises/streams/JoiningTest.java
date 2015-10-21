package houseware.learn.j8.exercises.streams;

import org.junit.Test;

import java.util.List;

import static houseware.learn.j8.exercises.streams.Joining.namesToString7;
import static houseware.learn.j8.exercises.streams.Joining.namesToString8;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author fphilip@houseware.es
 */
public class JoiningTest {

    @Test
    public void toStringShouldReturnPeopleNamesSeparatedByComma() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = asList(sara, viktor, eva);
        assertThat(namesToString7(collection))
                .isEqualTo("Names: Sara, Viktor, Eva.");
    }

    @Test
    public void compare() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = asList(sara, viktor, eva);
        assertThat(namesToString7(collection)).isEqualTo(namesToString8(collection));
    }
}
