package houseware.learn.j8.stream.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;


/**
 * @author fphilip@houseware.es
 */
public class FilterCollection {

    public static List<String> transform7(List<String> collection) {
        List<String> newCollection = new ArrayList<>();
        for (String element : collection) {
            if (element.length() < 4) {
                newCollection.add(element);
            }
        }
        return newCollection;
    }


    public static List<String> transform8(List<String> collection) {
        return collection.stream().filter(value -> value.length()<4).collect(Collectors.toList());

    }
}
