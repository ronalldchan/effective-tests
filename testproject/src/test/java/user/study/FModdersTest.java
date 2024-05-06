package user.study;

import org.effective.tests.EffectiveTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@EffectiveTest(FModders.class)
public class FModdersTest {
    @Test
    public void test1() {
        // creating classes
        FModders fm1 = new FModders();
        FModders fm2;
        fm2 = new FModders();

        // using methods
        fm1.setA(3);
        fm1.setB(4);

        // accessing fields
        int aField = fm1.getA();
        int cField;
        cField = fm1.getC();

        // assertions
        assertEquals(3, aField);
        assertEquals(2, cField); // does not have a code injection b/c C was never modified, so no need to register the assert
        assertEquals(3, fm1.sendThree());

        // using a method with multiple effects and using getters to obtain the values


        // branching if condition, will not record b/c no intersect values
        fm1.foo(13);
        if (Math.random() * 100 < 50) {
            assertEquals(13, fm1.getA());
            assertEquals(13, fm1.getC());
        } else {
            assertEquals(13, fm1.getA());
        }
    }
}
