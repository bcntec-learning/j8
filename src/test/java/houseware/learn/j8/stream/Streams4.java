package houseware.learn.j8.stream;

import org.junit.Test;

import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * @author fphilip@houseware.es
 */
public class Streams4 {

    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 1) {
                System.out.println(i);
            }
        }

        IntStream.range(0, 10)
                .forEach(i -> {
                    if (i % 2 == 1) System.out.println(i);
                });

        IntStream.range(0, 10)
                .filter(i -> i % 2 == 1)
                .forEach(System.out::println);

        OptionalInt reduced1 =
                IntStream.range(0, 10)
                        .reduce((a, b) -> a + b);
        System.out.println(reduced1.getAsInt());

        int reduced2 =
                IntStream.range(0, 10)
                        .reduce(7, (a, b) -> a + b);
        System.out.println(reduced2);
    }

    @Test
    public void test_optional(){

        OptionalInt reduced1 =
                IntStream.range(100, 10)
                        .reduce((a, b) -> a + b);
        System.out.println(reduced1.getAsInt());
    }
    @Test
    public void test_optional2(){

        Integer reduced1 =
                IntStream.range(100, 10)
                        .reduce(1, (a, b) -> a + b);
        System.out.println(reduced1);
    }
}
