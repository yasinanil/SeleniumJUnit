import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class C06_JUnitAssertions {

    @Test
    public void test01() {

        int number1 = 3;
        int number2 = 3;

        Assert.assertEquals("Values must be equal", number1, number2);

        Assert.assertEquals("Values must be equal", "Hello", "Hello");

    }

    @Test
    public void test02() {

        boolean isLessThan = 0 < 2;

        assertTrue("Value must be true", isLessThan);

        boolean isContain = "Hello".contains("lx");

        assertFalse("Value must be false", isContain);

    }

}
