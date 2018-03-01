package houseware.learn.j8.lambda;

import org.junit.Test;

/**
 * @author fphilip@houseware.es
 */
public class Lambda2 {

    @FunctionalInterface
    public static interface Converter<F, T> {
        T convert(F from);
    
    }
    

    static class Something {
        String startsWith(String s) {
            return String.valueOf(s.charAt(0));
        }
    }

    interface PersonFactory<P extends Person> {
        P create(String firstName, String lastName);
    }

    @Test
    public void test() {
        
        
        
        Converter<String, Integer> integerConverter0 = new Converter<String, Integer>() {
            private int l=1;
            @Override
            public Integer convert(String from) {
                return Integer.valueOf(from)+l;
            }
        };
        convertAndhow(integerConverter0 ,"123");

        //Lambda mode
        Converter<String, Integer> integerConverter11 = (from) -> {return Integer.valueOf(from);} ;
        convertAndhow(integerConverter11 ,"123");

        Converter<String, Integer> integerConverter12 = (from) -> Integer.valueOf(from);
        convertAndhow(integerConverter12 ,"123");


        // method reference

        Converter<String, Integer> integerConverter2 = Integer::valueOf;

        Integer converted2 = integerConverter2.convert("123");
        System.out.println(converted2);   // result: 123
        
        //o
        convertAndhow(integerConverter2, "123");
        convertAndhow(Integer::valueOf ,"123");
        convertAndhow(Float::valueOf ,"123.3");
        

        Something something = new Something();

        Converter<String, String> stringConverter = something::startsWith;

        String converted3 = stringConverter.convert("Java");
        System.out.println(converted3);    // result J

        //o

        convertAndhow(stringConverter, "Java");
        

        // constructor reference
        int ageDefault = 25;

        PersonFactory<Person> personFactory1 = (f,l) -> new Person(f,l,ageDefault);
        PersonFactory<Person> personFactory2 = Person::new;
        Person person1 = personFactory1.create("Peter", "Parker");
        Person person2 = personFactory2.create("Clark", "kent");
        System.out.println(person1);
        System.out.println(person2);
    }
    
    private <A,B> void convertAndhow(Converter<A, B> converter, A data){
        B er = converter.convert(data);
        System.out.println(er);
        
        
    }
}
