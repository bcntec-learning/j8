package houseware.learn.j8.staticMethod;

import org.junit.Test;

public class CaseInherit1 {


    interface A {
        void method();
        void method2();
    }

    interface C extends A {
        @Override
        default void method() {
            System.out.println("C");
        }
    }

    interface B extends A {
        @Override
        default void method() {
            System.out.println("B");
        }
    }
/*
     Error
    interface D extends B, C {

    }
*/

    interface D extends B, C {
        @Override
        default void method() {
            B.super.method(); //<<<<<<
        }

        @Override
        default void method2() {
            //todo fphilip

        }
    }
    class DImpl implements D {

    }

    @Test
    public void test(){
        D de = new DImpl();
        de.method();
    }

}
