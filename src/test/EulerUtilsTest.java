import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
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


        assertEquals(expected, EulerUtils.generatePrimes(10));
    }

    @Test
    void countDigits1111() {
        assertEquals(4, EulerUtils.countDigits(1111));
        assertEquals(4, EulerUtils.countDigits(-1111));
    }

    @Test
    void countDigitsEdgesCases() {
        assertEquals(0, EulerUtils.countDigits(0));
        assertEquals(1, EulerUtils.countDigits(-1));
        assertEquals(10, EulerUtils.countDigits(Integer.MAX_VALUE));
    }

    @Test
    void generateFibosUpToMax5() {
        List<BigInteger> list = new ArrayList<>();
        list.add(BigInteger.ONE);
        list.add(BigInteger.ONE);
        list.add(BigInteger.TWO);
        list.add(new BigInteger("3"));
        list.add(new BigInteger("5"));
        assertEquals(list, EulerUtils.generateFibosUpToMax(new BigInteger("5")));
    }

    @Test
    @Disabled
    void generateFibosUpToMax100000000000000000000() {
        List<BigInteger> list = new ArrayList<>();
        list.add(BigInteger.ONE);
        list.add(BigInteger.ONE);
        list.add(BigInteger.TWO);
        list.add(new BigInteger("3"));
        list.add(new BigInteger("5"));
        assertEquals(list, EulerUtils.generateFibosUpToMax(new BigInteger("100000000000000000000")));
    }

    @Test
    void concatTest123456(){
        assertEquals(123456, EulerUtils.concat(123, 456));
    }

    @Test
    void concatTest11111110(){
        assertEquals(11111110, EulerUtils.concat(111111, 10));
    }

    @Test
    void concatTest0(){
        assertEquals(0, EulerUtils.concat(0, 0));
    }
}