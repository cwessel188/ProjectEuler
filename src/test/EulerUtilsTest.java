import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EulerUtilsTest {

    @Test
    void generatePrimes10() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(3);
        expected.add(5);
        expected.add(7);

        // empty list for n = 1
        assertEquals(expected, EulerUtils.generatePrimes(10));
    }
}