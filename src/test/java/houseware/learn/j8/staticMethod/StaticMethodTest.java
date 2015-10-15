package houseware.learn.j8.staticMethod;

import org.junit.Test;

/**
 * @author fphilip@houseware.es
 */
public class StaticMethodTest {

    @Test
    public void test1() {
        System.out.println("Test 1");
        System.out.println("======");
        MyConsoleImpl obj = new MyConsoleImpl();
        obj.print("test1");
        obj.isNull("abc");
    }

    @Test
    public void test2() {
        System.out.println("Test 2");
        System.out.println("======");
        MyConsole obj = new MyConsoleImpl();
        obj.print("test2");
//        obj.isNull("abc"); not visible
    }
    @Test
    public void test3() {
        System.out.println("Test 3");
        System.out.println("======");
        MyConsole obj = new MyConsoleImpl2();
        obj.print("test3");
    }
}
