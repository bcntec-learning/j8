package houseware.learn.j8.dateTime;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
/**
 * @author fphilip@houseware.es
 */
public class DateAPILegacySupport {
 
    @Test
    public void test_1() {
         
        Instant timestamp = new Date().toInstant();
        System.out.println("Date to Instant "+timestamp);

        //Now we can convert Instant to LocalDateTime or other similar classes
        LocalDateTime date = LocalDateTime.ofInstant(timestamp, 
                        ZoneId.of(ZoneId.SHORT_IDS.get("PST")));
        System.out.println("Date = "+date);
         
        Instant time = Calendar.getInstance().toInstant();
        System.out.println("Calendar to Instant "+time);

        ZoneId defaultZone = TimeZone.getDefault().toZoneId();
        System.out.println("TimeZone to ZoneId "+defaultZone);
         
        ZonedDateTime gregorianCalendarDateTime = new GregorianCalendar().toZonedDateTime();
        System.out.println("ZonedDateTime from specific Calendar "+gregorianCalendarDateTime);
         

        Date dt = Date.from(Instant.now());
        System.out.println("Date API to Legacy classes "+dt);
         
        TimeZone tz = TimeZone.getTimeZone(defaultZone);
        System.out.println(tz);
         
        GregorianCalendar gc = GregorianCalendar.from(gregorianCalendarDateTime);
        System.out.println(gc);
         
    }
 
}