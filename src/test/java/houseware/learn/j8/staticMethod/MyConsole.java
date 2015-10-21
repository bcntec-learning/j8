package houseware.learn.j8.staticMethod;
/**
 * @author fphilip@houseware.es
 */
public interface MyConsole {

    default void print(String str) {
        if (!isNull(str))
            System.out.println("MyData Print::" + str);
    }
 
    static boolean isNull(String str) {
        System.out.println("Interface Null Check");
        return str == null ? true : "".equals(str) ? true : false;
    }
}
