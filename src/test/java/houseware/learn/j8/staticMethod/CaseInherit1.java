package houseware.learn.j8.staticMethod;

import org.junit.Test;

public class CaseInherit1 {


    @Test
    public void test() {
        D de = new DImpl();
        de.method();
    }

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
            System.out.println("houseware.learn.j8.B");
        }
    }


    interface D1 extends B, C {

        @Override
        default void method() {

        }
    }

    interface D extends B, C {

        @Override
        default void method() {
            C.super.method(); //<<<<<<
            B.super.method(); //<<<<<<
        }

        @Override
        default void method2() {
            //todo fphilip

        }
    }

    class DImpl implements  D  {

    }

    class D2Impl implements  B, C  {
        @Override
        public void method() {
           B.super.method();
           C.super.method();
        }

        @Override
        public void method2() {

        }
    }

}
