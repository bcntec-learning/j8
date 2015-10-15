package houseware.learn.j8.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author fphilip@houseware.es
 */
public class BooleanTest extends Assert {

    @Test
    public void test_and() {
        assertTrue(Boolean.logicalAnd(true, true));

    }

    @Test(expected = NullPointerException.class)
    public void test_and_with_null() {
        Boolean a = true;
        Boolean b = null;
        assertTrue(Boolean.logicalAnd(a, b));

    }

    @Test
    public void test_or() {
        assertTrue(Boolean.logicalOr(true, true));

    }

    @Test(expected = NullPointerException.class)
    public void test_or_with_null() {
        Boolean a = true;
        Boolean b = null;
        assertTrue(Boolean.logicalOr(a, b));

    }
    @Test
    public void test_xor() {
        assertFalse(Boolean.logicalXor(true, true));

    }

    @Test(expected = NullPointerException.class)
    public void test_xor_with_null() {
        Boolean a = true;
        Boolean b = null;
        assertFalse(Boolean.logicalXor(a, b));

    }
}
