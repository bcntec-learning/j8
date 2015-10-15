package houseware.learn.j8.stream;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author fphilip@houseware.es
 */
public class Streams6 {


    @Test
    public void test4() {
        Stream
                .of(new BigDecimal("1.2"), new BigDecimal("3.7"))
                .mapToDouble(BigDecimal::doubleValue)
                .average()
                .ifPresent(System.out::println);
    }

    @Test
    public void test3() {
        IntStream
                .range(0, 10)
                .average()
                .ifPresent(System.out::println);
    }

    @Test
    public void test2() {
        IntStream
                .builder()
                .add(1)
                .add(3)
                .add(5)
                .add(7)
                .add(11)
                .build()
                .average()
                .ifPresent(System.out::println);

    }

    @Test
    public void test1() {
        int[] ints = {1, 3, 5, 7, 11};
        Arrays
                .stream(ints)
                .average()
                .ifPresent(System.out::println);
    }
}
