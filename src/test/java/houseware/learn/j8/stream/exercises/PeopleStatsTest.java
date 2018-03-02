package houseware.learn.j8.stream.exercises;

import org.junit.Test;

import java.util.List;

import static houseware.learn.j8.stream.exercises.PeopleStats.getStats7;
import static houseware.learn.j8.stream.exercises.PeopleStats.getStats8;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author fphilip@houseware.es
 */
public class PeopleStatsTest {

    Person sara = new Person("Sara", 4);
    Person viktor = new Person("Francisco", 40);
    Person eva = new Person("Eva", 42);
    List<Person> collection = asList(sara, eva, viktor);

    @Test
    public void getStatsShouldReturnAverageAge() {
        assertThat(getStats7(collection).getAverage())
                .isEqualTo((double) (4 + 40 + 42) / 3);
    }

    @Test
    public void getStatsShouldReturnNumberOfPeople() {
        assertThat(getStats7(collection).getCount())
                .isEqualTo(3);
    }

    @Test
    public void getStatsShouldReturnMaximumAge() {
        assertThat(getStats7(collection).getMax())
                .isEqualTo(42);
    }

    @Test
    public void getStatsShouldReturnMinimumAge() {
        assertThat(getStats7(collection).getMin())
                .isEqualTo(4);
    }

    @Test
    public void getStatsShouldReturnSumOfAllAges() {
        assertThat(getStats7(collection).getSum())
                .isEqualTo(40 + 42 + 4);
    }

    @Test
    public void compare_min() {
        assertThat(
                getStats7(collection).getMin())
                .isEqualTo(getStats8(collection).getMin());
    }

    @Test
    public void compare_max() {
        assertThat(
                getStats7(collection).getMax())
                .isEqualTo(getStats8(collection).getMax());
    }

    @Test
    public void compare_average() {
        assertThat(
                getStats7(collection).getAverage())
                .isEqualTo(getStats8(collection).getAverage());
    }

    @Test
    public void compare_sum() {
        assertThat(
                getStats7(collection).getSum())
                .isEqualTo(getStats8(collection).getSum());
    }
    @Test
    public void compare_count() {
        Stats s = getStats8(collection);
        System.out.println(s.getCount());
        System.out.println(s.getSum());
        System.out.println(s.getMax());
        assertThat(
                getStats7(collection).getCount())
                .isEqualTo(s.getCount());
    }


}
