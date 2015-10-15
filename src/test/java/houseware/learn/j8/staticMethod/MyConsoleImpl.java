package houseware.learn.j8.staticMethod;

/**
 * @author fphilip@houseware.es
 */
public class MyConsoleImpl implements MyConsole {

    public boolean isNull(String str) {
        System.out.println("Impl Null Check");

        return str == null ? true : false;
    }



}
