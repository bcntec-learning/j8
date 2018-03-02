package houseware.learn.j8.stream.exercises;

import java.util.List;

/**
 * @author fphilip@houseware.es
 */
public class PeopleStats {

    public static Stats getStats7(List<Person> people) {
        long sum = 0;
        int min = people.get(0).getAge();
        int max = 0;
        for (Person person : people) {
            int age = person.getAge();
            sum += age;
            min = Math.min(min, age);
            max = Math.max(max, age);
        }
        return new Stats(people.size(), sum, min, max);
    }

    public static Stats getStats8(List<Person> people) {


        return people.stream()
                .mapToInt(Person::getAge).parallel()
                .collect(Stats::new,
                        Stats::accept,
                        Stats::combine);
    }

}
