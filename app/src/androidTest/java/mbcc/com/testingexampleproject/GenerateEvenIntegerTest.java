package mbcc.com.testingexampleproject;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by jravi on 12/9/14.
 */
public class GenerateEvenIntegerTest {

    @Test
    public void shouldGenerateRandomEvenInteger(){
        GenerateEvenIntegers gei = new GenerateEvenIntegers();
        assertTrue(gei.getEvenInteger() % 2 == 0);
    }
}
