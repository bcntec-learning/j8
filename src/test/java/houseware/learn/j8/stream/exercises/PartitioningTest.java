package houseware.learn.j8.stream.exercises;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static houseware.learn.j8.stream.exercises.Partitioning.partitionAdults7;
import static houseware.learn.j8.stream.exercises.Partitioning.partitionAdults8;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author fphilip@houseware.es
 */
public class PartitioningTest {

    @Test
    public void partitionAdultsShouldSeparateKidsFromAdults() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Francisco", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = asList(sara, eva, viktor);
        Map<Boolean, List<Person>> result = partitionAdults7(collection);
        assertThat(result.get(true)).hasSameElementsAs(asList(viktor, eva));
        assertThat(result.get(false)).hasSameElementsAs(asList(sara));
    }


    @Test
    public void compare() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Francisco", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = asList(sara, eva, viktor);

        Map<Boolean, List<Person>> result7 = partitionAdults7(collection);
        Map<Boolean, List<Person>> result8 = partitionAdults8(collection);
        assertThat(result7.get(true)).hasSameElementsAs(result8.get(true));
        assertThat(result7.get(false)).hasSameElementsAs(result8.get(false));
    }

}
