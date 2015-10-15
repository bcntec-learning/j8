package houseware.learn.j8.forEach;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;


public class IterateForEachTest {

    @Test
    public void iterable() {
        for (Integer integer : new MyList()) {
            System.out.println("Item iterable()" + integer);
        }
    }

    @Test
    public void forEach() {
        for (Integer integer : new MyList()) {
            System.out.println("Item forEach " + integer);
        }
    }

    @Test
    public void consumer() {

        MyConsumer action = new MyConsumer();
        new MyList().forEach(action);

    }

    @Test
    public void consumer_inner() {

        new MyList().forEach(t -> System.out.println("forEach anonymous class Value::" + t));


    }


    class MyConsumer implements Consumer<Integer> {

        public void accept(Integer t) {
            System.out.println("Consumer impl Value::" + t);
        }
    }


    /**
     * @author fphilip@houseware.es
     */
    public static class MyList extends ArrayList<Integer> {
        public MyList() {
            addAll(Arrays.asList(1, 2, 54, 6, 3, 6, 8, 3, 112, 6, 8, 4, 6));
        }

    }
}