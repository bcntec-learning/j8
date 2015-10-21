package houseware.learn.j8.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author fphilip@houseware.es
 */
public class Streams5 {

    List<String> stringCollection =
            Arrays.asList("d2", "a2", "b1", "b3", "c","a3");


    // stream has already been operated upon or closed
    @Test (expected = IllegalStateException.class)
    public void test7() {
        Stream<String> stream = stringCollection
                .stream()
                .filter(s -> s.startsWith("a"));

        stream.anyMatch(s -> true);
        stream.noneMatch(s -> true);
    }

    @Test
    public void test8() {

        Supplier<Stream<String>> streamSupplier =
                () -> stringCollection
                        .stream()
                        .filter(s -> s.startsWith("a"));

        /* Anounymous
        Supplier<Stream<String>> streamSupplier2 = new Supplier<Stream<String>>(){

            @Override
            public Stream<String> get() {
                return stringCollection
                                        .stream()
                                        .filter(s -> s.startsWith("a"));

            }
        };

    */
        streamSupplier.get().anyMatch(s -> true);
        streamSupplier.get().noneMatch(s -> true);
    }


    // short-circuit
    @Test
    public void test6() {
        boolean b= stringCollection
                .stream()
                .map(s -> {
                    System.out.println("map:      " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("A");
                });

    }

    @Test
    public void test5() {
        stringCollection
                .stream()
                .filter(s -> {
                    System.out.println("filter:  " + s);
                    return s.toLowerCase().startsWith("a");
                })
                .sorted((s1, s2) -> {
                    System.out.printf("sort:    %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .map(s -> {
                    System.out.println("map:     " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));
    }

    // sorted = horizontal
    @Test
    public void test4() {
        stringCollection
                .stream()
                .sorted((s1, s2) -> {
                    System.out.printf("sort:    %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .filter(s -> {
                    System.out.println("filter:  " + s);
                    return s.toLowerCase().startsWith("a");
                })
                .map(s -> {
                    System.out.println("map:     " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));
    }

    @Test
    public void test3() {
        stringCollection
                .stream()
                .filter(s -> {
                    System.out.println("filter:  " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map:     " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));
    }

    @Test
    public void test2() {
        stringCollection
                .stream()
                .map(s -> {
                    System.out.println("map:     " + s);
                    return s.toUpperCase();
                })
                .filter(s -> {
                    System.out.println("filter:  " + s);
                    return s.startsWith("A");
                })
                .forEach(s -> System.out.println("forEach: " + s));
    }

    @Test
    public void test1() {
        stringCollection
                .stream()
                .filter(s -> {
                    System.out.println("filter:  " + s);
                    return true;
                })
                .forEach(s -> System.out.println("forEach: " + s));
    }

}