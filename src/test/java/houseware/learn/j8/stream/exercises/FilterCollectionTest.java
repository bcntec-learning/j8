package houseware.learn.j8.stream.exercises;

import org.junit.Test;

import java.util.List;

import static houseware.learn.j8.stream.exercises.FilterCollection.transform7;
import static houseware.learn.j8.stream.exercises.FilterCollection.transform8;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author fphilip@houseware.es
 */
public class FilterCollectionTest {

    @Test
    public void transformShouldFilterCollection() {
        List<String> collection = asList("My", "name", "is", "John", "Doe");
        List<String> expected = asList("My", "is", "Doe");
        assertThat(transform7(collection)).hasSameElementsAs(expected);
    }

    @Test
    public void compare() {
        List<String> collection = asList("My", "name", "is", "John", "Doe");
        assertThat(transform7(collection)).hasSameElementsAs(transform8(collection));
    }

    @Test
    public void null_case() {
        List<String> collection = asList("My", "name", "is", null);
        collection.stream().filter(value -> value.length() < 4).forEach(System.out::println);

//        .forEach( p-> {
//             System.err.println(p+" es null?"+(p==null));
//         });

//           assertThat(transform8(collection)).hasSameElementsAs(expected);
    }


}
