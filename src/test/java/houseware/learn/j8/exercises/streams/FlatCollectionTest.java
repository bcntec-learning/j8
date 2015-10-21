package houseware.learn.j8.exercises.streams;

import org.junit.Test;

import java.util.Collection;
import java.util.List;

import static houseware.learn.j8.exercises.streams.FlatCollection.transform7;
import static houseware.learn.j8.exercises.streams.FlatCollection.transform8;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author fphilip@houseware.es
 */
public class FlatCollectionTest {

    @Test
    public void transformShouldFlattenCollection() {
        List<List<String>> collection = asList(asList("Viktor", "Farcic"), asList("John", "Doe", "Third"));
        List<String> expected = asList("Viktor", "Farcic", "John", "Doe", "Third");
        assertThat(transform7(collection)).hasSameElementsAs(expected);
    }

    @Test
    public void compare() {
        List<List<String>> collection = asList(asList("Viktor", "Farcic"), asList("John", "Doe", "Third"));
        assertThat(transform7(collection)).hasSameElementsAs(transform8(collection));
    }

    @Test
    public void case_null() {
        List<List<String>> collection = asList(asList("Viktor", "Farcic"),null);
        collection.stream() // Convert collection to Stream
        .flatMap(List::stream)
//        .flatMap(value -> value.stream())
                .forEach(System.out::println);

//        transform8(collection);
    }

}
