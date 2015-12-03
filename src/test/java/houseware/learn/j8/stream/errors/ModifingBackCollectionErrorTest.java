package houseware.learn.j8.stream.errors;

import org.junit.Test;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author fphilip@houseware.es
 */
public class ModifingBackCollectionErrorTest {

    @Test
    public void test() {
        List<Integer> list =
                IntStream.range(0, 10)
                        .boxed()
                        .collect(Collectors.toCollection(ArrayList::new));

        try {
            list.stream()
                    // remove(Object), not remove(int)!
                    .peek(list::remove)
                    .forEach(System.out::println);
        } catch (ConcurrentModificationException e) {

        }

        System.out.println(list);
    }




    @Test
    public void test_sorted() {
        List<Integer> list =
                IntStream.range(0, 10)
                        .boxed()
                        .collect(Collectors.toCollection(ArrayList::new));
        list.stream()
            .sorted()
            .peek(list::remove)
            .forEach(System.out::println);

        System.out.println(list);

    }
    @Test
    public void test_parallel() {
        List<Integer> list =
                IntStream.range(0, 10)
                        .boxed()
                        .collect(Collectors.toCollection(ArrayList::new));
        list.stream()
            .sorted()
            .parallel()
            .peek(list::remove)
            .forEach(System.out::println);


        System.out.println(list);

    }
}
