package houseware.learn.j8.stream.errors;

import org.junit.Test;

import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

/**
 * @author fphilip@houseware.es
 */
public class IntStreamErrorsTest {

//    @Test
    public void test_loop_inifinte() {

        IntStream.iterate(0, i -> i +1 ).forEach(System.out::println);
    }
    @Test
    public void test_loop_limied() {

        IntStream.iterate(100, i -> i +1 ).limit(10).forEach(System.out::println);
    }


    @Test
    public void test_mod_error() {

        IntStream.iterate(0, i -> (i +1)%2 ).distinct().limit(10).forEach(System.out::println);
    }

    @Test
    public void test_mod_ok() {

        IntStream.iterate(10, i -> (i +1)%2 ).limit(10).distinct().forEach(System.out::println);
    }

    
    @Test
    public void test_simple_order() {

        IntStream.iterate(0, i -> i +1 ).limit(10).sorted().forEach(System.out::println);
    }

//    @Test
    public void test_simple_order_problem() {

        IntStream.iterate(0, i -> i + 1).sorted().limit(10).forEach(System.out::println);
    }
    
    
    @Test
    public void test_simple_parallel_distinct() {

        IntStream.iterate(0, i -> i +1).parallel().distinct().limit(10).forEach(System.out::println);
    }
    @Test
    public void test_simple_parallel() {

        IntStream.iterate(0, i -> i +1 ).parallel().limit(10).distinct().forEach(System.out::println);
    }
    

//    @Test
    public void test_mod_parallel_distinct() {

        IntStream.iterate(0, i -> (i +1)%2).parallel().distinct().limit(10).forEach(System.out::println);
    }


    @Test
    public void test_mod_parallel_ok_distinct() {

        IntStream.iterate(0, i -> (i +1)%2).limit(10).parallel().distinct().forEach(System.out::println);
    }


    @Test
    public void test_limit_skip() {
        IntStream.iterate(0, i -> i + 1)
                .limit(10) // LIMIT
                .skip(5)   // OFFSET
                .forEach(System.out::println);
    }

}
