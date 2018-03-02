package houseware.learn.j8.stream;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

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
    public void test5() {
        Stream
                .of("1.2", "3.7", "3.7")
                .mapToDouble(Double::valueOf)
                .average()
                .ifPresent(System.out::println);
    }

    @Test(expected = NumberFormatException.class)
    public void test6() {
        Stream
                .of("1.2", "3.7", "3.7", "houseware.learn.j8.A")
                .mapToDouble(Double::valueOf)
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
    public void test31() {
        Supplier<Integer> s = new Supplier<Integer>() {
            int from = 0;
            int to = 10;

            @Override
            public Integer get() {
                if (from < to) {

                    return from++;
                }
                return null;

            }
        };
        Stream.of(s).forEach(System.out::print);
//                        .ifPresent(System.out::println);


    }

    @Test
    public void test31_lamda() {

        final AtomicInteger from = new AtomicInteger(0);
        final AtomicInteger to = new AtomicInteger(10);

        Supplier<Integer> supplier = () -> {
            if (from.get() < to.get()) {

                return from.getAndAdd(1);
            }
            return null;

        };


        StreamSupport.stream(
                takeWhile(supplier, Objects::nonNull, Long.MAX_VALUE), false)
                .filter(i -> i > 5)
                .forEach(System.out::print);


    }



    static <T> Spliterator<T> takeWhile(
            Supplier<T> supplier,
            Predicate<? super T> predicate,
            long estimation) {

        return new Spliterators.AbstractSpliterator<T>(estimation, 0) {

            @Override
            public boolean tryAdvance(Consumer<? super T> consumer) {
                T next = supplier.get();
                if (predicate.test(next)) {
                    consumer.accept(next);
                    return true;
                }
                return false;
            }
        };
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
