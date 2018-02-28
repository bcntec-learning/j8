package houseware.learn.j8.lambda;

public class LambdaEffectivelyFinal {


    public static void main(String[] args) {
        new LambdaEffectivelyFinal().method();
    }
    public void method() {
        String localVariable;
        localVariable = "Local";
        Foo foo = parameter -> {
            //UString localVariable = parameter; // already in use
            //localVariable = parameter; // use final or effectively final
            return localVariable.toUpperCase();
        };

        Foo fooInner = parameter -> {
            String localVariable1 = parameter; // already in use
            return localVariable1.toUpperCase();
        };

    }

    @FunctionalInterface
    public interface Foo {
        String method(String string);
    }
}
