package houseware.learn.j8.dateTime;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
/**
 * @author fphilip@houseware.es
 */
public class InstantExample {
 
    @Test
    public void test_1() {
        //Current timestamp
        Instant timestamp = Instant.now();
        System.out.println("Current Timestamp = "+timestamp);
         
        //Instant from timestamp
        Instant specificTime = Instant.ofEpochMilli(timestamp.toEpochMilli());
        System.out.println("Specific Time = "+specificTime);
         
        //Duration example
        Duration thirtyDay = Duration.ofDays(30);
        System.out.println(thirtyDay);
    }
 
}