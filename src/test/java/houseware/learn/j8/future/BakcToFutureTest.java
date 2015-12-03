package houseware.learn.j8.future;

import org.junit.Test;

import java.util.Date;
import java.util.concurrent.*;
import java.util.function.Supplier;

/**
 * @author fphilip@houseware.es
 */
public class BakcToFutureTest {


    @Test
    public void test1() throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(18);

        FutureTask<String> first1 = new FutureTask<>(() -> sleep(2, "first", Date::new));
        FutureTask<String> first2 = new FutureTask<>(() -> sleep(6, "second", Date::new));
        executor.execute(first1);
        executor.execute(first2);
        System.out.println(new Date());

        while (!(first1 != null && first1.isDone()) || !(first2 != null && first2.isDone())) {

            if (first2 != null && first2.isDone()) {
                System.out.println(first2.get());
                first2 = null;
            }
            if (first1 != null && first1.isDone()) {
                System.out.println(first1.get());
                first1 = null;
            }
        }


    }

    @Test
    public void completable(){
//        CompletableFuture

        ExecutorService executor = Executors.newFixedThreadPool(18);

//        FutureTask<String> first1 = new FutureTask<>(() -> sleep(2, "first", Date::new));
//        FutureTask<String> first2 = new FutureTask<>(() -> sleep(6, "second", Date::new));
        CompletableFuture c  = CompletableFuture.supplyAsync(() -> sleep(2, "first", Date::new), executor).thenAccept(System.out::print);
        CompletableFuture d =CompletableFuture.supplyAsync(() -> sleep(6, "second", Date::new), executor).thenAccept(System.out::print);




//        executor.execute(first1);
//        executor.execute(first2);
//        completableFuture.thenAccept(System.out::print);


    }


    public static String sleep(int t, String name, Supplier<Date> dateSupplier) {

        try {
            Thread.sleep(t * 1000);
        } catch (InterruptedException e) {

        }
        Date f = dateSupplier.get();
        return name + " " + f;

    }

}
