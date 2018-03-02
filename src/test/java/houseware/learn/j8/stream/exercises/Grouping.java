package houseware.learn.j8.stream.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;


/**
 * @author fphilip@houseware.es
 */
public class Grouping {

    public static Map<String, List<Person>> groupByNationality7(List<Person> people) {
        Map<String, List<Person>> map = new HashMap<>();
        for (Person person : people) {
            if (!map.containsKey(person.getNationality())) {
                map.put(person.getNationality(), new ArrayList<>());
            }
            map.get(person.getNationality()).add(person);
        }
        return map;
    }

    public static Map<String, List<Person>> groupByNationality8(List<Person> people) {
        return people.stream() // Convert collection to Stream
                .collect(groupingBy(Person::getNationality)); // Group people by nationality
    }

}
