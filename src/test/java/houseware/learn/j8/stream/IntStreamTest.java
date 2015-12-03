package houseware.learn.j8.stream;

import org.junit.Test;

import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

/**
 * @author fphilip@houseware.es
 */
public class IntStreamTest {

//    @Test
    public void test_error() {

        IntStream.iterate(0, i -> i +1 ).forEach(System.out::println);
    }


    @Test
    public void test_simple_ok() {

        IntStream.iterate(0, i -> i +1 ).limit(10).forEach(System.out::println);
    }


    @Test
    public void test_simple_problem_order() {

        IntStream.iterate(0, i -> i +1 ).limit(10).distinct().forEach(System.out::println);
    }


    @Test
    public void test_simple_parallel_4() {

        IntStream.iterate(0, i -> i +1).parallel().distinct().limit(10).forEach(System.out::println);
    }
    @Test
    public void test_simple_parallel() {

        IntStream.iterate(0, i -> i +1 ).parallel().limit(10).distinct().forEach(System.out::println);
    }



}
