package houseware.learn.j8.stream;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author fphilip@houseware.es
 */
public class Streams9 {

    @Test
    public void test() {
        Arrays.asList("a1", "a2", "b1", "c2", "c1")
            .stream()
            .filter(s -> s.startsWith("c"))
            .map(String::toUpperCase)
            .sorted()
            .forEach(System.out::println);

        // C1
        // C2
    }
}
