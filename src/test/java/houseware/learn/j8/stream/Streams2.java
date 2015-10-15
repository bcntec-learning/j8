package houseware.learn.j8.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fphilip@houseware.es
 */
public class Streams2 {

    @Test
    public void test() {

        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");


        // sorting

        stringCollection
                .stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println(stringCollection);

        

    }

}
