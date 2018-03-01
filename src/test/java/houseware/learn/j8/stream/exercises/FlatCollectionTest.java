package houseware.learn.j8.stream.exercises;

import org.junit.Test;

import java.util.Collection;
import java.util.List;

import static houseware.learn.j8.stream.exercises.FlatCollection.transform7;
import static houseware.learn.j8.stream.exercises.FlatCollection.transform8;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author fphilip@houseware.es
 */
public class FlatCollectionTest {

    @Test
    public void transformShouldFlattenCollection() {
        List<List<String>> collection = asList(asList("Francisco", "Philip"), asList("John", "Doe", "Third"));
        List<String> expected = asList("Francisco", "Philip", "John", "Doe", "Third");
        assertThat(transform7(collection)).hasSameElementsAs(expected);
    }

    @Test
    public void compare() {
        List<List<String>> collection = asList(asList("Francisco", "Philip"), asList("John", "Doe", "Third"));
        assertThat(transform7(collection)).hasSameElementsAs(transform8(collection));
    }

    @Test
    public void case_null() {
        List<List<String>> collection = asList(asList("Francisco", "Philip"),null);
        collection.stream() // Convert collection to Stream
        .flatMap(List::stream)
//        .flatMap(value -> value.stream())
                .forEach(System.out::println);

//        transform8(collection);
    }

}
