package houseware.learn.j8.exercises.streams;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * @author fphilip@houseware.es
 */
public class Sum {

    public static int calculate7(List<Integer> numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }

    public static int calculate8_(List<Integer> people) {
        return people.stream() // Convert collection to Stream
                .reduce(Integer::sum).orElse(0);
    }
    public static int calculate8__(List<Integer> people) {
        return people.stream() // Convert collection to Stream
                .reduce(0,
                        (total, number) -> total + number
                );
    }
    public static int calculate8(List<Integer> people) {
        return people.stream() // Convert collection to Stream
                .reduce(0, (total, number) -> total + number); // Sum elements with 0 as starting value
    }

}
