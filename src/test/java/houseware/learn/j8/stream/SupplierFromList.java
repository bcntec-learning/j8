package houseware.learn.j8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;

public class SupplierFromList {


    public static void main(String[] args) {
        List<Integer> list =  Arrays.asList(1,2,3,4,5);
        Iterator<Integer> i1 = list.iterator();
        Supplier<Integer> s1 = () -> i1.hasNext() ?  i1.next() : null;

        Integer e = null;
        do {
            e= s1.get(); //i1.hasNext() ?  i1.next() : null
            if(e!=null) {
                System.out.println(e);
            }
        } while (e!=null);







    }
}
