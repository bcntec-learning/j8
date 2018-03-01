package houseware.learn.j8.concurrency.concurrent.runnable;



public class EventLoggingTask implements  Runnable{
    @Override
    public void run() {

        String messge="Message read from the event queue";
        System.out.println("Message read from event queue is "+messge);

    }
}
