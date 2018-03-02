package houseware.learn.j8.lambda;

import org.junit.Test;

import java.util.function.Supplier;

/**
 * @author fphilip@houseware.es
 */
public class MethodAndConstructorReferences {

    @Test
    public void test1(){
        Supplier<Person> supplier = Person::new;

        for (int i = 0; i <2; i++) {
            Person p = supplier.get();
            p.firstName= "First"+i;
            p.lastName= "Last"+i;
            System.out.println(p);
        }
    }
}
