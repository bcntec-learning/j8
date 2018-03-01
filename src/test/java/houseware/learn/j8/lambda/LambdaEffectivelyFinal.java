package houseware.learn.j8.lambda;

public class LambdaEffectivelyFinal {


    public static void main(String[] args) {
        new LambdaEffectivelyFinal().method();
    }
    public void method() {
        String localVariable;
        localVariable = "Local";



        Foo foo = parameter -> {
            //String localVariable = parameter; // already in use
            //localVariable = parameter; // use final or effectively final
            return localVariable.toUpperCase();
        };

        //private void l(){}
        Foo inner = string -> {
            String localVariable1 = string;
            return localVariable1.toUpperCase();
        };

        foo = s -> s.toUpperCase();
        foo = String::toUpperCase;
        foo = String::valueOf;

    }

    @FunctionalInterface
    public interface Foo {
        String method(String string);
    }
}
