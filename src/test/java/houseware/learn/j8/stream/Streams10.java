package houseware.learn.j8.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.averagingInt;

/**
 * @author fphilip@houseware.es
 */
public class Streams10 {

    private static void test1(List<Person> persons) {
        List<Person> filtered =
                persons
                        .stream()
                        .filter(p -> p.name.startsWith("P"))
                        .collect(Collectors.toList());

        System.out.println(filtered);
        Assert.assertEquals("[Peter, Pamela]", filtered.toString());
    }

    private static void test2(List<Person> persons) {
        Map<Integer, List<Person>> personsByAge = persons
                .stream()
                .collect(Collectors.groupingBy(p -> p.age));

        personsByAge
                .forEach((age, p) -> System.out.format("age %s: %s\n", age, p));

        // age 18: [Max]
        // age 23:[Peter, Pamela]
        // age 12:[David]
    }

    private static void test3(List<Person> persons) {
        Double averageAge = persons
                .stream()
                .collect(averagingInt(p -> p.age));

        System.out.println(averageAge);
        Assert.assertEquals("19.0", averageAge.toString());

    }

    private static void test4(List<Person> persons) {
        IntSummaryStatistics ageSummary =
                persons
                        .stream()
                        .collect(Collectors.summarizingInt(p -> p.age));

        System.out.println(ageSummary);
        Assert.assertEquals("IntSummaryStatistics{count=4, sum=76, min=12, average=19.000000, max=23}", ageSummary.toString());
    }

    private static void test5(List<Person> persons) {
        String names = persons
                .stream()
                .filter(p -> p.age >= 18)
                .map(p -> p.name)
                .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));

        System.out.println(names);
        Assert.assertEquals("In Germany Max and Peter and Pamela are of legal age.", names);
    }

    private static void test6(List<Person> persons) {
        Map<Integer, String> map = persons
                .stream()
                .collect(Collectors.toMap(
                        p -> p.age,
                        p -> p.name,
                        (name1, name2) -> name1 + ";" + name2));

        System.out.println(map);
        Assert.assertEquals("{18=Max, 23=Peter;Pamela, 12=David}", map.toString());
    }

    private static void test7(List<Person> persons) {
        Collector<Person, StringJoiner, String> personNameCollector =
                Collector.of(
                        () -> new StringJoiner(" | "),          // supplier
                        (j, p) -> j.add(p.name.toUpperCase()),  // accumulator
                        (j1, j2) -> j1.merge(j2),               // combiner
                        StringJoiner::toString);                // finisher

        String names = persons
                .stream()
                .collect(personNameCollector);

        System.out.println(names);
        Assert.assertEquals("MAX | PETER | PAMELA | DAVID", names);
    }

    private static void test8(List<Person> persons) {

        String names = persons
                .stream()
                .collect(personNameCollector());

        System.out.println(names);
        Assert.assertEquals("MAX | PETER | PAMELA | DAVID", names);
    }

    private static void test9(List<Person> persons) {
        Collector<Person, StringJoiner, String> personNameCollector = personNameCollector();

        String names = persons
                .parallelStream()
                .collect(personNameCollector);

        System.out.println(names);
        Assert.assertEquals("MAX | PETER | PAMELA | DAVID", names);
    }

    private static Collector<Person, StringJoiner, String> personNameCollector() {
        return
                Collector.of(
                        () -> {
                            System.out.println("supplier");
                            return new StringJoiner(" | ");
                        },
                        (j, p) -> {
                            System.out.format("accumulator: p=%s; j=%s\n", p, j);
                            j.add(p.name.toUpperCase());
                        },
                        (j1, j2) -> {
                            System.out.println("merge");
                            return j1.merge(j2);
                        },
                        j -> {
                            System.out.println("finisher");
                            return j.toString();
                        });
    }

    @Test
    public void test() {
        List<Person> persons =
                Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("David", 12));

        test1(persons);
        test2(persons);
        test3(persons);
        test4(persons);
        test5(persons);
        test6(persons);
        test7(persons);
        test8(persons);
        test9(persons);
    }

    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
