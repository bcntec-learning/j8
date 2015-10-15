package houseware.learn.j8.concurrency;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author fphilip@houseware.es
 */
public class Executors2 {


    @Test(expected = TimeoutException.class)
    public void test3() throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        Future<Integer> future = executor.submit(() -> {
                TimeUnit.SECONDS.sleep(2);
                return 123;
        });

        future.get(1, TimeUnit.SECONDS);
    }

    @Test(expected = ExecutionException.class)
    public void test2() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        Future<Integer> future = executor.submit(() -> {
            TimeUnit.SECONDS.sleep(1);
            return 123;
        });

        executor.shutdownNow();
        future.get();
    }

    @Test(expected = ExecutionException.class)
    public void test1() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        Future<Integer> future = executor.submit(() -> {
            TimeUnit.SECONDS.sleep(1);
            return 123;
        });

        System.out.println("future done: " + future.isDone());

        Integer result = future.get();

        System.out.println("future done: " + future.isDone());
        System.out.print("result: " + result);

        executor.shutdownNow();
    }

}