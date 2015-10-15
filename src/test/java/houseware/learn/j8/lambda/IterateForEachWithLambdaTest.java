package houseware.learn.j8.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;


public class IterateForEachWithLambdaTest {

    @SuppressWarnings("all")
    @Test
    public void iterable() {
        Iterator<Integer> it = new MyList().iterator();
        while (it.hasNext()) {
            System.out.println("Item iterable()" + it.next());
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

    @SuppressWarnings("all")
    @Test
    public void consumer_inner() {

        new MyList().forEach(new Consumer<Integer>() {

            public void accept(Integer t) {
                System.out.println("forEach anonymous class Value::" + t);
            }

        });


    }


    //Consumer implementation that can be reused
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