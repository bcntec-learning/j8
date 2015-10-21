package houseware.learn.j8.exercises.streams;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author fphilip@houseware.es
 */
public class FlatCollection {

    public static List<String> transform7(List<List<String>> collection) {
        List<String> newCollection = new ArrayList<>();
        for (List<String> subCollection : collection) {
            for (String value : subCollection) {
                newCollection.add(value);
            }
        }
        return newCollection;
    }

    public static List<String> transform8(List<List<String>> collection) {
        return collection.stream() // Convert collection to Stream
                .flatMap(value -> value.stream()) // Replace list with stream
                .collect(toList()); // Collect results to a new list
    }

}
