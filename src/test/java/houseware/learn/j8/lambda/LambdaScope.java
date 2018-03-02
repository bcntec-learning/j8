package houseware.learn.j8.lambda;

import java.util.function.Function;

public class LambdaScope {

    private String value = "Enclosing scope value";

    public static void main(String[] args) {
        String s = new LambdaScope().scopeExperiment();
        System.out.println(s);

    }

    public String scopeExperiment() {
        Foo fooIC = new Foo() {
            String value = "Inner class value";

            @Override
            public String method(String string) {
                return this.value;
            }
        };

        String resultIC = fooIC.method("");


        Foo fooLambda = parameter -> {
            String value = "Lambda value";
            return this.value;
        };

        String resultLambda = fooLambda.method("");

        return "Results: resultIC = " + resultIC +
                ", resultLambda = " + resultLambda;
    }

    @FunctionalInterface
    public interface Foo {
        String method(String string);
    }
}
