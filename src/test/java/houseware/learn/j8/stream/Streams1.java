package houseware.learn.j8.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author fphilip@houseware.es
 */
public class Streams1 {

    static List<String> stringCollection = Arrays.asList(
            "ddd2", "aaa2", "bbb1", "aaa1", "bbb3", "ccc", "bbb2", "ddd1");


    @Test
    public void test_mapping() {        // mapping

        stringCollection
                .stream()
                                        .map(String::toUpperCase)

                        //                .map(new Function<String, String>() {
                        //                    @Override
                        //                    public String apply(String s) {
                        //                        return s.toUpperCase();
                        //
                        //                    }
                        //                })
//                                        .map(s -> s.toUpperCase())
                        //                .map(s -> {return s.toUpperCase();})
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);

        // "DDD2", "DDD1", "CCC", "BBB3", "BBB2", "AAA2", "AAA1"
    }

    @Test
    public void test_filtering() {


        // filtering

        stringCollection
                .stream()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);

        // "aaa2", "aaa1"

    }

    @Test
    public void test_sorting() {


        // sorting

        stringCollection
                .stream()
                .sorted()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);

        // "aaa1", "aaa2"


    }

    @Test
    public void test_matching() {
        // matching

        boolean anyStartsWithA = stringCollection
                .stream()
                .anyMatch((s) -> s.startsWith("a"));

        System.out.println(anyStartsWithA);      // true

        boolean allStartsWithA = stringCollection
                .stream()
                .allMatch((s) -> s.startsWith("a"));

        System.out.println(allStartsWithA);      // false

        boolean noneStartsWithZ = stringCollection
                .stream()
                .noneMatch((s) -> s.startsWith("z"));

        System.out.println(noneStartsWithZ);      // true


    }

    @Test
    public void test_counting() {
        // counting

        long startsWithB = stringCollection
                .stream()
                .filter((s) -> s.startsWith("b"))
                .count();

        System.out.println(startsWithB);    // 3


    }

    @Test
    public void test_reducing() {

        // reducing

        Optional<String> reduced =
                stringCollection
                        .stream()
                        .sorted()
                        .reduce((s1, s2) -> s1 + "#" + s2);

        reduced.ifPresent(System.out::println);
        // "aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2"


    }

}
